package com.mycompany.myapp.activemq;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.domain.EmployeeAddress;
import com.mycompany.myapp.domain.MockPg;
import com.mycompany.myapp.domain.Pay;
import com.mycompany.myapp.domain.ProductInfo;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIs {

    private static Logger log = LoggerFactory.getLogger(RestAPIs.class);

    @Lazy
    @Autowired
    private RestAPIs service;

    @Autowired
    ProducerResource jmsProducer;

    @Autowired
    private MessageStorage customerStorage;

    @Autowired
    private KieSession session;

    @Value("${spring.application.MockPgUrl}")
    private String MockPgUrl;
    @Value("${spring.application.EmployeeAddressUrl}")
    private  String EmployeeAddressUrl;
    @Value("${spring.application.ProductInfoUrl}")
    private  String ProductInfoUrl;
    @Value("${spring.application.ProductInfoArrayUrl}")
    private String ProductInfoArrayUrl;

    @Lazy
    @Async("taskExecutor")
    public CompletableFuture<MockPg> returnMockData() throws IOException, InterruptedException {
        String MockPgUrl = System.getProperty("MockPgUrl", this.MockPgUrl);
        ObjectMapper object = new ObjectMapper();
        URL url = new URL(MockPgUrl);
        MockPg mockpg = object.readValue(url, MockPg.class);
        System.out.println(mockpg);
        // session.insert(mockpg);
        //  session.fireAllRules();
        return CompletableFuture.completedFuture(mockpg);
    }

    @Lazy
    @Async("taskExecutor")
    public CompletableFuture<EmployeeAddress> returnEmployeeAddress() throws IOException, InterruptedException {
        String EmployeeAddressUrl = System.getProperty("EmployeeAddressUrl", this.EmployeeAddressUrl);
        ObjectMapper object = new ObjectMapper();
        URL url = new URL(EmployeeAddressUrl);
        Thread.sleep(1000L);
        EmployeeAddress employAdress = object.readValue(url, EmployeeAddress.class);
        System.out.println(employAdress);
         session.insert(employAdress);
         session.fireAllRules();
        return CompletableFuture.completedFuture(employAdress);









    }

    @Lazy
    @Async("taskExecutor")
    public CompletableFuture<ProductInfo> returnProductInfo() throws IOException, InterruptedException {
        String ProductInfoUrl = System.getProperty("ProductInfoUrl", this.ProductInfoUrl);
        ObjectMapper object = new ObjectMapper();
        URL url = new URL(ProductInfoUrl);
        Thread.sleep(1000L);
        ProductInfo productInfo = object.readValue(url, ProductInfo.class);
        session.insert(productInfo);
        session.fireAllRules();
        System.out.println(productInfo);
        // session.insert(mockpg);
        //  session.fireAllRules();
        return CompletableFuture.completedFuture(productInfo);
    }

    @Async("taskExecutor")
    @PostMapping(value = "/api/productInfo")
    public void product(@RequestBody ProductInfo product ) throws IOException, InterruptedException, ExecutionException {
        session.insert(product);
        session.fireAllRules();
        }



    @Async("taskExecutor")
    @PostMapping(value = "/api/pays")
    public Pay postCustomer(@RequestBody Pay customer) throws IOException, InterruptedException, ExecutionException {
       // session.insert(customer);
       // session.fireAllRules();
       jmsProducer.send(customer);

         // CompletableFuture<MockPg> mockPg = service.returnMockData();
         CompletableFuture<EmployeeAddress> employeeAdress = service.returnEmployeeAddress();
       // CompletableFuture<ProductInfo> productInfo = service.returnProductInfo();
        CompletableFuture.allOf(employeeAdress).join();

        // log.info("MockData--> " + mockPg.get());
        System.out.println("###############################################################################");
        System.out.println("###############################################################################");
         log.info("EmployeeAddress--> " + employeeAdress.get());
         System.out.println("###############################################################################");
         System.out.println("###############################################################################");
      //   log.info("ProductInfo--> " + productInfo.get());

       // Thread.sleep(1000L);
        return customer;
    }

    @GetMapping(value = "/api/customers")
    public List<Pay> getAll() {
        List<Pay> customers = customerStorage.getAll();
        return customers;
    }

    @DeleteMapping(value = "/api/customers/{id}")
    public String clearCustomerStorage(@PathVariable String id) {
        customerStorage.clear(id);
        return "Clear  CustomerStorage!";
    }


    @GetMapping("/api/productInfo")
    public ProductInfo[] ProductInfo() throws IOException {
        String ProductInfoArrayUrl = System.getProperty("ProductInfoArrayUrl", this.ProductInfoArrayUrl);
        ObjectMapper object = new ObjectMapper();
        object.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        object.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        URL url = new URL(ProductInfoArrayUrl);

        ProductInfo[] productInfo = object.readValue(url, ProductInfo[].class);
        System.out.println(productInfo);
        return productInfo;
    }



}
