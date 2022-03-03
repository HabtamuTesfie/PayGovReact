package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Pay;
import com.mycompany.myapp.repository.PayRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.util.Configuration;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;


import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.sdk.exceptions.PayPalException;
import java.io.FileNotFoundException;
import liquibase.exception.InvalidChangeDefinitionException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;

import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.GetAuthDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsReq;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutRequestType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentResponseDetailsType;
import urn.ebay.apis.eBLBaseComponents.GetExpressCheckoutDetailsResponseDetailsType;
import urn.ebay.apis.eBLBaseComponents.PayerInfoType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;
import urn.ebay.apis.eBLBaseComponents.SetExpressCheckoutRequestDetailsType;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.Pay}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class PayResource {

    private final Logger log = LoggerFactory.getLogger(PayResource.class);

    private static final String ENTITY_NAME = "pay";
    Pay payAmount;


    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    @Value("${spring.application.emailAdress}")
    private String emailAdress;


    @Value("${spring.application.emailPassword}")
    private String emailPassword;


    @Value("${spring.application.RedirectURL}")
    private String RedirectURL;

    @Value("${spring.application.returnURL}")
    private String returnURL;

    @Value("${spring.application.cancelURL}")
    private String cancelURL;


    private final PayRepository payRepository;

    public PayResource(PayRepository payRepository) {
        this.payRepository = payRepository;
    }

    /**
     * {@code POST  /pays} : Create a new pay.
     *
     * @param pay the pay to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pay, or with status {@code 400 (Bad Request)} if the pay has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */


    @PostMapping("/amountOfMoney")
    public String getPayment(@Valid @RequestBody Pay pay) throws URISyntaxException {
        this.payAmount = pay;
        return "payAmount";
    }


    @PostMapping("/payment")
    public ResponseEntity<Pay> createPay(@RequestBody Pay pay) throws URISyntaxException,AddressException, MessagingException, IOException {
        String password = System.getProperty("password",this.emailPassword);
        String emailAd = System.getProperty("emailAd",this.emailAdress);
        String email=pay.getEmail();
        String name=pay.getName();
        String approval=pay.getApproval();
        System.out.println("#####################################################################################");
        System.out.println("#####################################################################################");
        System.out.println("email  :"+email+",name: "+name+",approval: "+approval);
        System.out.println("#####################################################################################");
        System.out.println("#####################################################################################");

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(emailAd);
        mailSender.setPassword(password);

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        mailSender.setJavaMailProperties(properties);





       log.debug("REST request to save Pay : {}", pay);
        if (pay.getId() != null) {
            throw new BadRequestAlertException("A new pay cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Pay result = payRepository.save(pay);
     SimpleMailMessage message = new SimpleMailMessage();
         message.setFrom(emailAd);
        message.setTo(email);
        message.setSubject("PAYGOV NOTIFICATION");
        message.setText("Hello Mister "+name+" Your last payment is "+approval+" ,Thanks!!!");

        mailSender.send(message);


        return ResponseEntity
            .created(new URI("/api/pays/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }










    /**
     * {@code PUT  /pays/:id} : Updates an existing pay.
     *
     * @param id the id of the pay to save.
     * @param pay the pay to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pay,
     * or with status {@code 400 (Bad Request)} if the pay is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pay couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pays/{id}")
    public ResponseEntity<Pay> updatePay(@PathVariable(value = "id", required = false) final Long id, @RequestBody Pay pay)
        throws URISyntaxException {
        log.debug("REST request to update Pay : {}, {}", id, pay);
        if (pay.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pay.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!payRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Pay result = payRepository.save(pay);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, pay.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /pays/:id} : Partial updates given fields of an existing pay, field will ignore if it is null
     *
     * @param id the id of the pay to save.
     * @param pay the pay to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pay,
     * or with status {@code 400 (Bad Request)} if the pay is not valid,
     * or with status {@code 404 (Not Found)} if the pay is not found,
     * or with status {@code 500 (Internal Server Error)} if the pay couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/pays/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Pay> partialUpdatePay(@PathVariable(value = "id", required = false) final Long id, @RequestBody Pay pay)
        throws URISyntaxException {
        log.debug("REST request to partial update Pay partially : {}, {}", id, pay);
        if (pay.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pay.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!payRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Pay> result = payRepository
            .findById(pay.getId())
            .map(existingPay -> {
                if (pay.getCik() != null) {
                    existingPay.setCik(pay.getCik());
                }
                if (pay.getCcc() != null) {
                    existingPay.setCcc(pay.getCcc());
                }
                if (pay.getPaymentAmount() != null) {
                    existingPay.setPaymentAmount(pay.getPaymentAmount());
                }
                if (pay.getName() != null) {
                    existingPay.setName(pay.getName());
                }
                if (pay.getEmail() != null) {
                    existingPay.setEmail(pay.getEmail());
                }
                if (pay.getPhone() != null) {
                    existingPay.setPhone(pay.getPhone());
                }
                if (pay.getApproval() != null) {
                    existingPay.setApproval(pay.getApproval());
                }

                return existingPay;
            })
            .map(payRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, pay.getId().toString())
        );
    }

    /**
     * {@code GET  /pays} : get all the pays.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pays in body.
     */
    @GetMapping("/pays")
    public List<Pay> getAllPays() {
        log.debug("REST request to get all Pays");
        return payRepository.findAll();
    }

    /**
     * {@code GET  /pays/:id} : get the "id" pay.
     *
     * @param id the id of the pay to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pay, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pays/{id}")
    public ResponseEntity<Pay> getPay(@PathVariable Long id) {
        log.debug("REST request to get Pay : {}", id);
        Optional<Pay> pay = payRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(pay);
    }

    /**
     * {@code DELETE  /pays/:id} : delete the "id" pay.
     *
     * @param id the id of the pay to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pays/{id}")
    public ResponseEntity<Void> deletePay(@PathVariable Long id) {
        log.debug("REST request to delete Pay : {}", id);
        payRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }



    SetExpressCheckoutResponseType setExpressCheckoutResponse;

    @GetMapping("/paypal")
    public String setExpressCheckout()
       // throws PayPalException, XPathExpressionException, ClientActionRequiredException, SSLConfigurationException, MissingCredentialException, InvalidResponseDataException, InvalidCredentialException, IOException, ParsedNodeException, HttpErrorException, SAXException, ParserConfigurationException, InvalidChangeDefinitionException
       throws  SSLConfigurationException,PayPalException,InvalidCredentialException,IOException,FileNotFoundException
       ,HttpErrorException,SAXException,InvalidResponseDataException,ParserConfigurationException,ClientActionRequiredException
       ,InvalidChangeDefinitionException, MissingCredentialException, InterruptedException{
        String url = System.getProperty("url",this.RedirectURL);
        String returnURL = System.getProperty("returnURL",this.returnURL);
        String cancelURL = System.getProperty("cancelURL",this.cancelURL);

        Long PayerId = 5l;
        String paymentAmount = payAmount.getPaymentAmount().toString();
        // String returnURL = "http://localhost:9000/payment-save";
        // String cancelURL = "http://localhost:9000/";
        PaymentActionCodeType paymentAction = PaymentActionCodeType.SALE;
        CurrencyCodeType currencyCode = CurrencyCodeType.EUR;

        Map<String, String> configurationMap = Configuration.getAcctAndConfig();
        // Creating service wrapper object to make an API call by loading configuration map.
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(configurationMap);

        //construct the request
        SetExpressCheckoutRequestType setExpressCheckoutReq = new SetExpressCheckoutRequestType();
        setExpressCheckoutReq.setVersion("63.0");

        //construct the details for the request
        SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();

        PaymentDetailsType paymentDetails = new PaymentDetailsType();
        paymentDetails.setOrderDescription("PayGove integration with paypal");
        paymentDetails.setInvoiceID("INVOICE-" + Math.random());
        BasicAmountType orderTotal = new BasicAmountType();
        orderTotal.setValue(paymentAmount);
        orderTotal.setCurrencyID(currencyCode);
        paymentDetails.setOrderTotal(orderTotal);
        paymentDetails.setPaymentAction(paymentAction);
        details.setPaymentDetails(Arrays.asList(new PaymentDetailsType[] { paymentDetails }));
        details.setReturnURL(returnURL);
        details.setCancelURL(cancelURL);
        details.setCustom(PayerId.toString());

        setExpressCheckoutReq.setSetExpressCheckoutRequestDetails(details);

        SetExpressCheckoutReq expressCheckoutReq = new SetExpressCheckoutReq();
        expressCheckoutReq.setSetExpressCheckoutRequest(setExpressCheckoutReq);

        setExpressCheckoutResponse = service.setExpressCheckout(expressCheckoutReq);
        getExpressCheckoutDetails(setExpressCheckoutResponse.getToken());

        //return setExpressCheckoutResponse.getToken();
        String RedirectURL =(url + setExpressCheckoutResponse.getToken());
        System.out.println("====================================================================");
        System.out.println("====================================================================");
        System.out.println("====================================================================");
        System.out.println(JSONObject.quote(RedirectURL));
        System.out.println("====================================================================");
        System.out.println("====================================================================");
        System.out.println("====================================================================");
        System.out.println(JSONObject.quote(RedirectURL));
        System.out.println("====================================================================");
        System.out.println("====================================================================");
        System.out.println("====================================================================");

        return JSONObject.quote(RedirectURL);
    }

    public String startgetExpressResponse2()
        throws ClientActionRequiredException, SSLConfigurationException, MissingCredentialException, OAuthException, InvalidResponseDataException, InvalidCredentialException, IOException, ParserConfigurationException, HttpErrorException, InterruptedException, SAXException {
        try {
            getExpressCheckoutDetails(setExpressCheckoutResponse.getToken());
        } catch (InvalidChangeDefinitionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (PayPalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "GET is started";
    }

    @GetMapping("/paypalGetChechout")
    public String startDoExpresResponse()
        throws ClientActionRequiredException, InvalidChangeDefinitionException, SSLConfigurationException, MissingCredentialException, InvalidResponseDataException, InvalidCredentialException, IOException, ParserConfigurationException, HttpErrorException, InterruptedException, SAXException, PayPalException {
        doExpressResponse(getExpressCheckoutDetails(setExpressCheckoutResponse.getToken()));

        return "SUCCESS PAYMENT WITH TRANSACTION ID =" + getExpressCheckoutDetails(setExpressCheckoutResponse.getToken());
    }

    public GetExpressCheckoutDetailsResponseDetailsType getExpressCheckoutDetails(String token)
        throws PayPalException, FileNotFoundException, SAXException, ParserConfigurationException, SSLConfigurationException, InvalidChangeDefinitionException, UnsupportedEncodingException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, OAuthException, IOException, InterruptedException, InvalidCredentialException
         {
        // CallerServices caller = new CallerServices();

        // APIProfile profile = ...;
        Map<String, String> configurationMap = Configuration.getAcctAndConfig();
        // Creating service wrapper object to make an API call by loading configuration
        // map.
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(configurationMap);

        GetExpressCheckoutDetailsReq grequest = new GetExpressCheckoutDetailsReq();
        GetExpressCheckoutDetailsRequestType pprequest = new GetExpressCheckoutDetailsRequestType();
        pprequest.setVersion("63.0");
        // pprequest.setToken(token);

        grequest.setGetExpressCheckoutDetailsRequest(new GetExpressCheckoutDetailsRequestType(token));
        GetExpressCheckoutDetailsResponseType ppresponse = service.getExpressCheckoutDetails(grequest);

        ppresponse.getGetExpressCheckoutDetailsResponseDetails().getPayerInfo().getPayerID();
        ppresponse.getGetExpressCheckoutDetailsResponseDetails().getToken();
        ppresponse.getAck();
        ppresponse.getGetExpressCheckoutDetailsResponseDetails();

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");

        System.out.println(ppresponse.getGetExpressCheckoutDetailsResponseDetails().getPayerInfo().getPayerID() + " payerID");

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");

        System.out.println(ppresponse.getAck() + " ack");

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");

        System.out.println(ppresponse.getGetExpressCheckoutDetailsResponseDetails().getToken() + " TOKEN");

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(ppresponse.getGetExpressCheckoutDetailsResponseDetails().getPaymentDetails() + " PAYMENTDETAILS");

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(ppresponse.getGetExpressCheckoutDetailsResponseDetails().getPaymentInfo() + " PAYMENTINFO");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(ppresponse.getGetExpressCheckoutDetailsResponseDetails().getBillingAddress() + " BILLINGADRESS");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(ppresponse.getGetExpressCheckoutDetailsResponseDetails().getCheckoutStatus() + " CHECKOUTSTATUS");

        // doExpressResponse(ppresponse.getGetExpressCheckoutDetailsResponseDetails());
        return ppresponse.getGetExpressCheckoutDetailsResponseDetails();
    }

    public void doExpressResponse(GetExpressCheckoutDetailsResponseDetailsType response)
        throws PayPalException, FileNotFoundException, SAXException, ParserConfigurationException, SSLConfigurationException, InvalidChangeDefinitionException, UnsupportedEncodingException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, OAuthException, IOException, InterruptedException, InvalidCredentialException {
        // CallerServices caller = new CallerServices();
        // doExpressResponse(ppresponse.getGetExpressCheckoutDetailsResponseDetails());
        // APIProfile profile = ...;
        // APIProfile profile = ...;
        Map<String, String> configurationMap = Configuration.getAcctAndConfig();
        // Creating service wrapper object to make an API call by loading configuration
        // map.
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(configurationMap);

        DoExpressCheckoutPaymentRequestType pprequest = new DoExpressCheckoutPaymentRequestType();
        pprequest.setVersion("63.0");

        // DoExpressCheckoutPaymentResponseType ppresponse= new
        // DoExpressCheckoutPaymentResponseType();

        DoExpressCheckoutPaymentRequestDetailsType paymentDetailsRequestType = new DoExpressCheckoutPaymentRequestDetailsType();

        paymentDetailsRequestType.setPaymentDetails(response.getPaymentDetails());
        paymentDetailsRequestType.setToken(response.getToken());
        //PayerInfoType payerInfo = response.getPayerInfo();
        paymentDetailsRequestType.setPayerID(response.getPayerInfo().getPayerID());
        paymentDetailsRequestType.setPaymentAction(PaymentActionCodeType.SALE);
        pprequest.setDoExpressCheckoutPaymentRequestDetails(paymentDetailsRequestType);
        // DoExpressCheckoutPaymentReq
        // paymentDetailsRequestType.setPaymentDetails(response.getPaymentDetails());
        // pprequest.setDoExpressCheckoutPaymentRequestDetails(paymentDetailsRequestType);
        DoExpressCheckoutPaymentReq payRequest1 = new DoExpressCheckoutPaymentReq();
        payRequest1.setDoExpressCheckoutPaymentRequest(pprequest);
        DoExpressCheckoutPaymentResponseType ppresponse = service.doExpressCheckoutPayment(payRequest1);

        System.out.println(ppresponse.getAck() + " PAYMENT");

        DoExpressCheckoutPaymentResponseDetailsType type = ppresponse.getDoExpressCheckoutPaymentResponseDetails();
        /*if (type != null) {
    List<PaymentInfoType> paymentInfo = type.getPaymentInfo();
    if (((PaymentInfoType) paymentInfo).getPaymentStatus()
            .equals(PaymentStatusCodeType.fromValue("Completed"))) {
        log.info("Payment completed.");
        return;
    } else {
        log.info("Payment not completed.. (" + ((PaymentInfoType) paymentInfo).getPaymentStatus() + ")");
        return;
    }
} else {
    log.info(
            "Problem executing DoExpressCheckoutPayment.. Maybe you tried to process an ExpressCheckout that has already been processed.");
    return;
}*/

    }









}
