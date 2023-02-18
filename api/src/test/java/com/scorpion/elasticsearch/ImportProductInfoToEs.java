package com.scorpion.elasticsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.*;
import com.scorpion.mapper.ProductMapper;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/5/15
 */
@SpringBootTest
public class ImportProductInfoToEs {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Resource
    private ProductMapper ProductMapper;

    @Resource
    private ObjectMapper ObjectMapper;

    /**
     * 创建索引
     */
    @Test
    public void testCreateIndex() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("iuproductindex");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        createIndexResponse.isAcknowledged();

    }

    /**
     * 导入商品数据到Es
     */
    @Test
    public void testImportProductInfo() throws IOException {
        //  1、从数据库中获取全部商品数据
        String attrName="";
        String skuName="";
        String attrValue="";
        String purchasedTime="";
        String oldness="";

        List<ProductVo> productVos = ProductMapper.selectProductToEs();
        for (int i = 0; i < productVos.size(); i++) {
            //  1.1、获取商品列表需要的字段（1:productId,2:productContent,3:productImage,4、oldness,5、purchasedTime,6、attrName,
            //  7、sellPrice,8、originalPrice,9、attrValue）
            BigDecimal originalPrice = new BigDecimal(0.0);
            BigDecimal sellPrice = new BigDecimal(0.0);

            Integer productId = productVos.get(i).getProductId();
            Integer categoryId = productVos.get(i).getCategoryId();
            Integer tabId = productVos.get(i).getTabId();
            String productName = productVos.get(i).getProductName();
            String productContent = productVos.get(i).getProductContent();
            List<ProductImg> imgs = productVos.get(i).getProductImgs();
            String productImage =imgs.size()==0?"":imgs.get(0).getUrl();
            List<ProductSkuVo> skus = productVos.get(i).getProductSkus();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(skus.size()>0) {
                skuName = skus.get(0).getSkuName();
                sellPrice = skus.get(0).getSellPrice();
                originalPrice=skus.get(0).getOriginalPrice();
                oldness=skus.get(0).getOldness();
                purchasedTime = simpleDateFormat.format(skus.get(0).getPurchasedTime());
                List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValue =skus.get(0).getPmsSkuSaleAttrValue();
                for (int j = 0; j < pmsSkuSaleAttrValue.size(); j++) {
                    if(j<pmsSkuSaleAttrValue.size()-1) {
                        attrName += pmsSkuSaleAttrValue.get(j).getAttrName() + ",";
                        attrValue+=pmsSkuSaleAttrValue.get(j).getAttrValue()+",";
                    }else{
                        attrName+=pmsSkuSaleAttrValue.get(j).getAttrName();
                        attrValue+=pmsSkuSaleAttrValue.get(j).getAttrValue();
                    }
                }

            }else {
                 attrName=null;
                 attrValue=null;
                 purchasedTime=null;
                 oldness=null;
                 skuName=null;
            }

            ProductToEs product = new ProductToEs().builder()
                    .productId(productId)
                    .categoryId(categoryId)
                    .tabId(tabId)
                    .skuName(skuName)
                    .productName(productName)
                    .productContent(productContent)
                    .productImage(productImage)
                    .oldness(oldness)
                    .purchasedTime(purchasedTime)
                    .attrName(attrName)
                    .attrValue(attrValue)
                    .originalPrice(originalPrice)
                    .sellPrice(sellPrice)
                    .build();
            System.out.println(product);
            //  2、将数据导入到es中
           IndexRequest indexRequest = new IndexRequest("iuproductindex");
            indexRequest.id(productId+"");
            indexRequest.source(ObjectMapper.writeValueAsString(product), XContentType.JSON);
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println(i+1+":"+indexResponse);
        }

    }

}
