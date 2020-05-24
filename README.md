# SpringBoot_Rest_webservice

**Dynamic filtering**

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
**Implementing Basic Authentication**

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

### **What is Versioning?**
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

