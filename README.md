# SpringBoot_Rest_webservice

## Swagger.documentation

- Add Swagger Documentation dependencys
```
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.4.0</version>
</dependency>
```
```
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.4.0</version>
</dependency>
```
**Created SwaggerConfigclass**

1. Configuration SwaggerConfig class by using  ```@configuration```
2. EnableSwagger Swagger by using ```@EnableSwagger2```
3. Produces and Consume our endpoints in ``XML``and ```Json```  we are using ```".produces(DEFAULT_PRODUCES_AND_CONSUMES)"```,```.consumes(DEFAULT_PRODUCES_AND_CONSUMES);```
Inside the **DEFAULT_PRODUCES_AND_CONSUMES** I provided **XML**,**JSON**

```
private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
new HashSet<String>(Arrays.asList("application/json", "application/xml"));
```

- Also i provided Customize Contact in DEFAULT_Contact

```
public static final Contact DEFAULT_Contact = 
new Contact("Amit Kumar Das","https://github.com/AKD1997/SpringBoot_Rest_webservice","akdasjob97@gmail.com");
```

- Also i have customize Api information  ```.apiInfo(DEFAULT_API_INFO)```

- Here i provided the "DEFAULT_API_INFO" value
```
public static final ApiInfo DEFAULT_API_INFO = 
new ApiInfo("Rest Api Resourse", "Rest Api Documentation", "1.0","urn:tos", DEFAULT_Contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
```
- Also i provider User description in ***User*** class  by using ```@apimodel```
```
@apimodel(description = "HERE WE CAN SEE THE USER DETAILS ")
```
- And also privide some notes in "name","bdayDate" by using "@ApiModelProperty".
```
@ApiModelProperty(notes = "Name Should have at list 4 Character")
private String name;

@ApiModelProperty(notes = "Birth date should be in the past")
private Date bdayDate;
```

## **Actuator and hal browser**

**Spring Boot Actuator** is a sub-project of the Spring Boot Framework. It includes a number of additional features that help us to monitor and manage the Spring Boot application. It contains the actuator endpoints (the place where the resources live). We can use **HTTP** and **JMX** endpoints to manage and monitor the Spring Boot application. If we want to get production-ready features in an application, we should use the **Spring Boot actuator**.

### **Enabling Spring Boot Actuator**

- We can enable actuator by injecting the dependency ```spring-boot-starter-actuator``` in the ```pom.xml``` file.
```
<dependency>
  	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
- To look at the services which are provided we actuator in a browser so we add
```"spring-data-rest-hal-browser"``` depenancy
```
<dependency>
	<groupId>org.springframework.data</groupId>
	<artifactId>spring-data-rest-hal-browser</artifactId>
</dependency>
```
**INFO:-**
To Add info we need configure our ```application.property``` there is a lot of stuff that actuator providedes to enable that we would need to configure property
The way we can do by using  
```
management.endpoints.web.exposure.include=*
```
- We can see this in Browser By using 
```
http://localhost:8080/actuator
http://localhost:8080/browser/index.html#/actuator
```

## **Filtering**
### **1. Static filtering**
>What is Static filtering ?

**Ex:** I'm sending a get request to application i'm geeting a response back with **(id,name,secondname)**.Let say i don't want to see the **id** to end user in that  concept is called filteging.
Here I'm done Static_filtering by using ```(@JsonIgnore,@JsonIgnoreProperties)```

Example +1
```
@JsonIgnoreProperties(value = { "firstname", "Secondname" })
public class Customer {
	private Integer id;
	private String firstname;
	private String Secondname;
	private String familyname;
```

Example +1
```
public class Customer {
	@JsonIgnore
	private Integer id;
	private String firstname;
	private String Secondname;
	private String familyname;
	@JsonIgnore
	private Integer password;
```
### **2. Dynamic filtering**

>What is Dynamic filtering ?

**EX:-** Some request i would send 'firstname','secondname'  and some other request  i want to send 'familyname','id' that basicaly concept of dynamic filtering.

With  Dynamic filtering  we cannot configure filtering directly on the bean .we need to start configuring the filtering where they're retriving the values

- The ```MappingJacksonValue``` class need constructor argument that basicaly the bean that wee are passing in `` new MappingJacksonValue(customer)``
 ``` 
 MappingJacksonValue mapping = new MappingJacksonValue(customer);
 ``` 
After Doing this I would to create a mapping jackson value for this paticular bean
```
mapping.setFilters(filters);
```
Over here you can configure the ``` "filters" ``` To configure the filters I would need to create a local variable ``"FilterProvider filters ="`` ,so we would need to now configure the filters

We would want to only send  'field1', 'field2'  for that in  "FilterProvider " there is a abstract class "SimpleBeanPropertyFilter" In SimpleBeanPropertyFilter there is a (.addFilter("customerfilter", filter)) method
```
FilterProvider filters = new SimpleFilterProvider().addFilter("customerfilter", filter);
```
In ```SimpleBeanPropertyFilter``` there is a another method ``` filterOutAllExcept ```by using this we can pass our fields
```
SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter .filterOutAllExcept("firstname", "id");
```
## **Implementing Basic Authentication**

Spring Boot Security dependency is added on the classpath, Spring Boot application automatically requires the Basic Authentication for all HTTP Endpoints. The Endpoint “/” and “/home” does not require any authentication. All other Endpoints require authentication.

For adding a Spring Boot Security to your Spring Boot application, we need to add the Spring Boot Starter Security dependency in our build configuration file.

Maven users can add the following dependency in the pom.xml file.
 ```  
 <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
        
And also i enable sesurity at application.properties

```
spring.security.user.name=Amit
```
```
spring.security.user.password=kumar
```
## **Versioning**
> What is Versioning?

**Ex**:- Suppose in versions_1 we have a field "name" we evolved and over a period of time we recognized the need for having a separate "Firstname" and " last name" we decided in version_2 

_**There are 4 types of versioning**_

1. Media type versioning -GitHub use this versioning 
2. (Custom) Headers versioning - Microsoft use this versioning 
3. URI versioning -Twitter use this versioning 
4. Request parameter Versioning - Amazone use this versioning  

**1. Media type versioning**
```
@GetMapping(value = "/person/paramv1", params = "version=2")
	public PersonV1 paramv1() {
		return new PersonV1("Bob rahul");
	}
	@GetMapping(value = "/person/paramv2", params = "version=2")
	public PersonV2 paramv2() {
		return new PersonV2(new Name("Bob", "rahul"));

	}
```
**2. (Custom) Headers versioning**
```
@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerv1() {
		return new PersonV1("Bob rahul");
	}
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerv2() {
		return new PersonV2(new Name("Bob", "rahul"));
	}
```
**3. URI versioning**
```
@GetMapping("v1/person")
	public PersonV1 persionv1() {
		return new PersonV1("Bob rahul");
	}
	@GetMapping("v2/person")
	public PersonV2 persionv2() {
		return new PersonV2(new Name("Bob", "rahul"));
	}
```
**4. Request parameter Versioning**
```
@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesv1() {
		return new PersonV1("Bob rahul");
	}
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesv2() {
		return new PersonV2(new Name("Bob", "rahul"));
	}
```
### **URI Pollution**

- The _**URI Versioning**_ and the **_Request parameter Versioning_** we are actually polluting the URI space 

- The _**Media type versioning**_ and **_Headers versioning_** actually we are not polluting the URI space at all 

- But _**Media type versioning**_ and _**Headers versioning**_  do misuse of HTTP headers HTTP header was never intended for versioning And Another important factor is **_Caching_**  because these2 approaches use headers to differentiate between the requests 
- The Caching can never come into the picture  because I can not cache request because they have the same URL

- Also, need to look at the headers and do complicated things like that 
- So Caching becomes very difficult  But in  the _**URI Versioning**_ and the **_Request parameter Versioning_** we can still cache them because the version is part of the URL 
-The other important factor the _**URI Versioning**_ and the **_Request parameter Versioning_** we can execute a request on the browser. 

- The _**Media type versioning**_ and **_Headers versioning_** we can not execute a request on the browser. to execute browser we need to have some kind of technical knowledge to be able to configure an HTTP header But If we are using The _**URI Versioning**_ and the **_Request parameter Versioning_**  a normal user would be able to fire a request 

- Important things are Documentation You need to ensure that whatever things that you are using is documentation very well so your consumers know how to send the versioning input to your service 

