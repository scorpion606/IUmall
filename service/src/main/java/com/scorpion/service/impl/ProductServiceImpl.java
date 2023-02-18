package com.scorpion.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.*;
import com.scorpion.mapper.ProductImgMapper;
import com.scorpion.mapper.ProductMapper;
import com.scorpion.mapper.ProductParamsMapper;
import com.scorpion.mapper.ProductSkuMapper;
import com.scorpion.service.ProductService;
import com.scorpion.vo.PageHelper;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author scorpion
 * @date 2021/11/13
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductImgMapper productImgMapper;
    @Resource
    private ProductSkuMapper productSkuMapper;
    @Resource
    private ProductParamsMapper productParamsMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Override
    public ResultVo listRecommendProductions() {
        List<ProductVo> productVos = productMapper.selectRecommendProductions();
        if(productVos.size() == 0) {
            return new ResultVo(ResponseStatus.fail,"fail",null);
        }
        return new ResultVo(ResponseStatus.success,"success",productVos);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResultVo listProductsDetails(int productId) {
        /*try {
            //  1、从redis查询商品基本信息
            String productJson =(String) stringRedisTemplate.boundHashOps("product").get(String.valueOf(productId));
            //  2、判断redis中是否存在商品信息
            if(productJson!=null){
                //  3、redis中存在商品信息直接返回
                Product product = objectMapper.readValue(productJson, Product.class);
                //  从redis中查询商品图片
                String productImagesJson = (String)stringRedisTemplate.boundHashOps("productImages").get(String.valueOf(productId));
                //  将json字符串转化为以ProductImg为对象的list集合
                JavaType javaType1 = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, ProductImg.class);
                List<ProductImg> productImgs =objectMapper.readValue(productImagesJson,javaType1);
                //  从redis中查询商品套餐
                String productSkuJson =(String) stringRedisTemplate.boundHashOps("productSku").get(String.valueOf(productId));

                JavaType javaType2 = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, ProductSkuVo.class);
                List<ProductSkuVo> productSkus =objectMapper.readValue(productSkuJson,javaType2);

                //  封装商品基本信息、商品图片、商品套餐为HashMap集合
                HashMap<String,Object> map=new HashMap<>();
                map.put("products",product);
                map.put("productImgs",productImgs);
                map.put("productSkus",productSkus);
                return new ResultVo(ResponseStatus.success,"list success",map);
            }else{
                synchronized (this){
                    String Json =(String) stringRedisTemplate.boundHashOps("product").get(String.valueOf(productId));
                    if(Json==null){
                        //  4、redis中不存在商品信息，则去数据库中查找并存入redis中，返回商品信息
                        //查询商品信息
                        Example example = new Example(Product.class);
                        Example.Criteria criteria = example.createCriteria();
                        criteria.andEqualTo("productId",productId);
                        criteria.andEqualTo("productStatus",1);
                        List<Product> products = productMapper.selectByExample(example);
                        if(products.size()>0){
                            stringRedisTemplate.boundHashOps("product").put(String.valueOf(productId),objectMapper.writeValueAsString(products.get(0)));
                            //查询商品图片
                            List<ProductImg> productImgs = productImgMapper.selectProductDetailImagesByPid(productId);
                            stringRedisTemplate.boundHashOps("productImages").put(String.valueOf(productId),objectMapper.writeValueAsString(productImgs));
                            List<ProductSkuVo> productSkus = productSkuMapper.selectProductSkuByPid(productId);
                            stringRedisTemplate.boundHashOps("productSku").put(String.valueOf(productId),objectMapper.writeValueAsString(productSkus));
                            //将查询到的商品详情信息存入HashMap内存中
                            HashMap<String,Object> productsDetailsMap=new HashMap<>();
                            productsDetailsMap.put("products",products.get(0));
                            productsDetailsMap.put("productImgs",productImgs);
                            productsDetailsMap.put("productSkus",productSkus);
                            return new ResultVo(ResponseStatus.success,"success",productsDetailsMap);
                        }else{
                            stringRedisTemplate.boundHashOps("product").put(String.valueOf(productId),objectMapper.writeValueAsString("[]"));
                            stringRedisTemplate.boundHashOps("product").expire(10, TimeUnit.SECONDS);
                            stringRedisTemplate.boundHashOps("productImages").put(String.valueOf(productId),objectMapper.writeValueAsString("[]"));
                            stringRedisTemplate.boundHashOps("productImages").expire(10, TimeUnit.SECONDS);
                            stringRedisTemplate.boundHashOps("productSku").put(String.valueOf(productId),objectMapper.writeValueAsString("[]"));
                            stringRedisTemplate.boundHashOps("productSku").expire(10, TimeUnit.SECONDS);

                        }
                    }else{
                        //  3、redis中存在商品信息直接返回
                        Product product = objectMapper.readValue(Json, Product.class);
                        //  从redis中查询商品图片
                        String productImagesJson = (String)stringRedisTemplate.boundHashOps("productImages").get(String.valueOf(productId));
                        //  将json字符串转化为以ProductImg为对象的list集合
                        JavaType javaType1 = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, ProductImg.class);
                        List<ProductImg> productImgs =objectMapper.readValue(productImagesJson,javaType1);
                        //  从redis中查询商品套餐
                        String productSkuJson =(String) stringRedisTemplate.boundHashOps("productSku").get(String.valueOf(productId));
                        JavaType javaType2 = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, ProductSkuVo.class);
                        List<ProductSkuVo> productSkus =objectMapper.readValue(productSkuJson,javaType2);
                        //  封装商品基本信息、商品图片、商品套餐为HashMap集合
                        HashMap<String,Object> map=new HashMap<>();
                        map.put("products",product);
                        map.put("productImgs",productImgs);
                        map.put("productSkus",productSkus);
                        return new ResultVo(ResponseStatus.success,"list success",map);
                    }
                }


            }

        }catch (Exception e){
            e.printStackTrace();

        }*/
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        criteria.andEqualTo("productStatus",1);
        List<Product> products = productMapper.selectByExample(example);
        //查询商品图片
        List<ProductImg> productImgs = productImgMapper.selectProductDetailImagesByPid(productId);
        List<ProductSkuVo> productSkus = productSkuMapper.selectProductSkuByPid(productId);
        //  封装商品基本信息、商品图片、商品套餐为HashMap集合
        HashMap<String,Object> map=new HashMap<>();
        map.put("products",products);
        map.put("productImgs",productImgs);
        map.put("productSkus",productSkus);
        return new ResultVo(ResponseStatus.success,"list success",map);
    }

    @Override
    public ResultVo listProductPrams(int productId) {
        Example example=new Example(ProductParams.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("productId",productId);
        List<ProductParams> productParams = productParamsMapper.selectByExample(example);
        if(productParams.size()>0){
            return new ResultVo(ResponseStatus.success,"success",productParams.get(0));
        }else {
            return new ResultVo(ResponseStatus.fail,"fail",null);
        }

    }

    @Override
    public ResultVo listCategoryProducts(int categoryId, int pageNum, int limit) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId",categoryId);
        //该分类下商品总数量
        int count = productMapper.selectCountByExample(example);
        //计算总页数
        int pageCount=count%limit==0?count/limit:count/limit+1;
        //计算开始索引
        int start=(pageNum-1)*limit;
        //获取该categoryID下的分页商品
        List<ProductVo> list = productMapper.selectCategoryProducts(categoryId, start, limit);
        return new ResultVo(ResponseStatus.success,"success",new PageHelper<>(count,pageCount,list));
    }

    @Override
    public ResultVo listBrandProducts(int categoryId) {
        List<String> brands = productMapper.selectBrandByCategoryId(categoryId);
        return new ResultVo(ResponseStatus.success,"success",brands);
    }

    @Override
    public ResultVo listProductByKeyWord(String keyWord, int pageNum, int limit) {

        ResultVo resultVo=null;
        try {
        //  开始索引
        int start = (pageNum - 1) * limit;

        //  创建es查询请求
        SearchRequest searchRequest = new SearchRequest("iuproductindex");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //  创建查询条件
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(keyWord,"productContent","skuName"));

        //  创建分页条件
        searchSourceBuilder.from(start);
        searchSourceBuilder.size(limit);

        //  高亮显示
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        HighlightBuilder.Field productContent = new HighlightBuilder.Field("productContent");
        highlightBuilder.field(productContent);
        highlightBuilder.preTags("<label style='color:red'>");
        highlightBuilder.postTags("</label>");
        searchSourceBuilder.highlighter(highlightBuilder);
        searchRequest.source(searchSourceBuilder);

        //  执行检索
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //  封装查询结果
        SearchHits hits = searchResponse.getHits();
        //  获取总记录
        int count = (int)hits.getTotalHits().value;
        //  获取总页数
        int pageCount=count%limit==0?count/limit:count/limit+1;

        List<ProductToEs> list=new ArrayList<>();
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            SearchHit searchHit = iterator.next();
            ProductToEs product = objectMapper.readValue(searchHit.getSourceAsString(), ProductToEs.class);
            //  获取高亮字段
            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
            HighlightField productContent1 = highlightFields.get("productContent");
            if(productContent1!=null){
                String highlightFiled = Arrays.toString(productContent1.fragments());
                product.setProductContent(highlightFiled);
            }
            list.add(product);
        }
        resultVo=new ResultVo(ResponseStatus.success,"list success",new PageHelper<>(count,pageCount,list));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultVo;
        
    }



    @Override
    public ResultVo listBrandByKeyWord(String keyWord) {
        keyWord="%"+keyWord+"%";
        List<String> brands = productMapper.selectBrandByKeyWord(keyWord);
        return new ResultVo(ResponseStatus.success,"success",brands);
    }

    @Override
    public ResultVo listSearchResultByKeyWord(String keyWord) {
        keyWord="%"+keyWord+"%";
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("productName",keyWord);
        criteria.orLike("productContent",keyWord);
        criteria.orLike("keyWord",keyWord);
        List<Product> products = productMapper.selectByExample(example);
        return new ResultVo(ResponseStatus.success,"success",products);
    }

    @Override
    public ResultVo listProductByCIdOrKeyWord(String keyWord, Integer cId, int pageNum, int limit) {
        int pageCount;
        int start;
        int count;
        ResultVo resultVo=null;
        if(keyWord!=null&&!"".equals(keyWord)) {

            try {
                //  开始索引
                start = (pageNum - 1) * limit;

                //  创建es查询请求
                SearchRequest searchRequest = new SearchRequest("iuproductindex");
                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

                //  创建查询条件
                searchSourceBuilder.query(QueryBuilders.multiMatchQuery(keyWord,"productContent","skuName"));

                //  创建分页条件
                searchSourceBuilder.from(start);
                searchSourceBuilder.size(limit);

                //  高亮显示
                HighlightBuilder highlightBuilder = new HighlightBuilder();
                HighlightBuilder.Field productContent = new HighlightBuilder.Field("productContent");
                highlightBuilder.field(productContent);
                highlightBuilder.preTags("<label style='color:#00a1d6'>");
                highlightBuilder.postTags("</label>");
                searchSourceBuilder.highlighter(highlightBuilder);
                searchRequest.source(searchSourceBuilder);

                //  执行检索
                SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
                //  封装查询结果
                SearchHits hits = searchResponse.getHits();
                //  获取总记录
                count = (int)hits.getTotalHits().value;
                //  获取总页数
                pageCount=count%limit==0?count/limit:count/limit+1;

                List<ProductToEs> list=new ArrayList<>();
                Iterator<SearchHit> iterator = hits.iterator();
                while (iterator.hasNext()){
                    SearchHit searchHit = iterator.next();
                    ProductToEs product = objectMapper.readValue(searchHit.getSourceAsString(), ProductToEs.class);
                    //  获取高亮字段
                    Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
                    HighlightField productContent1 = highlightFields.get("productContent");
                    if(productContent1!=null){
                        String highlightFiled = Arrays.toString(productContent1.fragments());
                        product.setProductContent(highlightFiled);
                    }
                    list.add(product);
                }
                resultVo=new ResultVo(ResponseStatus.success,"list success",new PageHelper<>(count,pageCount,list));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if(String.valueOf(cId)!=null&&!"0".equals(String.valueOf(cId))){
            try {
                start=(pageNum-1)*limit;
                SearchRequest searchRequest = new SearchRequest("iuproductindex");
                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                searchSourceBuilder.query(QueryBuilders.termQuery("categoryId",cId));
                searchSourceBuilder.from(start);
                searchSourceBuilder.size(limit);
                searchRequest.source(searchSourceBuilder);
                SearchResponse searchResponse = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
                SearchHits hits = searchResponse.getHits();
                count =(int)hits.getTotalHits().value;
                pageCount=count%limit==0?count/limit:count/limit+1;
                List<ProductToEs> list=new ArrayList<>();
                Iterator<SearchHit> iterator = hits.iterator();
                while (iterator.hasNext()){
                    SearchHit searchHit = iterator.next();
                    ProductToEs product = objectMapper.readValue(searchHit.getSourceAsString(), ProductToEs.class);
                    list.add(product);
                }
                resultVo=new ResultVo(ResponseStatus.success,"list success",new PageHelper<>(count,pageCount,list));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return resultVo;
    }

    @Override
    public ResultVo autoCompletion(String prefix, int limit) {
        /**
         *
         */
        ResultVo resultVo=null;
        try {
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        //定义本次查询名字product_name_suggest,设置prefix 补齐前缀，查询个数limit个，skipDuplicates去除重复数据
        CompletionSuggestionBuilder completionSuggestionBuilder = SuggestBuilders.completionSuggestion("productName")
                .prefix(prefix)
                .size(limit)
                .skipDuplicates(true);
        suggestBuilder.addSuggestion("product_name_suggest",completionSuggestionBuilder);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //  高亮显示
        /*HighlightBuilder highlightBuilder = new HighlightBuilder();
        HighlightBuilder.Field productContent = new HighlightBuilder.Field("productName");
        highlightBuilder.field(productContent);
        highlightBuilder.preTags("<label style='color:#00a1d6'>");
        highlightBuilder.postTags("</label>");
        searchSourceBuilder.highlighter(highlightBuilder);*/

        SearchRequest searchRequest = new SearchRequest("iuproductindex").source(searchSourceBuilder.suggest(suggestBuilder));


        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            Suggest suggest = response.getSuggest();

            Set<String> keywords = null;
            if (suggest != null) {
                keywords = new HashSet<>();
                List<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> entries
                        = suggest.getSuggestion("product_name_suggest").getEntries();

                for (Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option> entry : entries) {
                    for (Suggest.Suggestion.Entry.Option option: entry.getOptions()) {
                        // 最多返回9个数据, 每个长度最大为20
                        String keyword = option.getText().string();
                        if (keyword!=null && keyword.length() <= 20) {

                            keywords.add(keyword);
                            if (keywords.size() >= 9) {
                                break;
                            }
                        }
                    }
                }
            }
            resultVo=new ResultVo(ResponseStatus.success,"list success",keywords);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultVo;
    }
}
