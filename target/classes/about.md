# usage
##resources/
    save all static resources
##static/
    save all static resources
    e.g. js,css,images
##templates/
    save all template page
    Spring Boot use default jar insertion Tomcat, provides no support for jsp pages
##application.properties
    global configuration file of a SpringBoot apps
    application.properties / application.yml
    
    properties/tmal can be placed in:
        1.file:./config/
        2.file:./
        3.classpath:/config/
        4.classpath:/
    (order by priority desc)
##YAML
###YAML grammar
    k: v signifys a key-value pair
    space count signifys level of domain
    
    String(default no quotation mark):
        sample string : output "sample string"
        'sample \n string': output "sample /n string"
        "sample \n string": output "sample
                                    string"
    
    MAP
        friends:
            lm: Geogre
            ag: 40                           
            
    List/Set
        pets:(signify elem of array by " - elem")
            - cat
            - dog
            - pig
        
        pets: [cat,dog,pig]
 
 ##thymeleaf
    according to thymeleaf:
        public static final String DEFAULT_PREFIX = "classpath:/templates/";
        public static final String DEFAULT_SUFFIX = ".html";
    find files in resources/templates, append .html
    
 ###thymeleaf grammar
    1. use html head <html lang="en" xmlns:th="http://www.thymeleaf.org"> import thymeleaf namespace
    2. use thymeleaf grammar
     grammar:
     
        1. th: (AnyPropertyOfHTML)
            th: text/ th: id/ th: class/ th: each/ ...
        
        2. Exp grammar
            ${} : get var value (OGNL EXP)
            
                ${ObjA.A.a} cascade property
                ${ObjA['A']['a']} cascade property
                ${map['Geogre Washington'].age} map.get
                ${array[4].elem} array
                ${ObjA.methodA("param")} call method
                
                ${#locale.country} "#OBJ" CALL INTERNAL OBJ
                {
                    internal tool class:
                        #execInfo
                        #number
                        #calenders
                        #dates
                        #arrays
                        #lists
                        #bools
                        #strings
                        #ids
                        #maps
                        #sets
                        #messages
                        #conversations
                }
                
            *{} : var selection exp
                
                same function of ${}
                
                additional: (along with th: object, '*' represnts session.user)
                {
                    <div th: object = "${session.user}">
                        <p>Name: <span th: text = "*{firstNmae}"> aaa </span></p>
                    </div>
                }
                
            #{} : get international content
            
            @{} : def url herf link
                
                (use insertion ${} to simplify grammar(instead of use '?' and strcats))
                <a herf = "2.html" th: herf = "@{http://localhost:8899/detail(orderID = ${o.id})}"> view </a>
            
            ~{} : fragment quote exp
            
            * / + - < <= > >= == != and or not...
            
            ? / ?:
            
            
 ##SpringMVC in SpringBoot
    
    springMVC has been auto configured in spring boot
        1. ViewResolver
                               
        