# IT-product-management-app-

## What it does ?
 It is an app that helps IT stores to manage their products, you can performe basic oprations such as (erach,add,remove,modify) products.
 I have developped this  JEE app using Servlet, JSP, JSTL respecting the **MVC** Pattern.
 I used potgresql(v14) as database server , tomcat(v9.0) as webserver and maven as build tool.
 <ul>
 <li>The Business layer contains an interface, an implementation of the interface and a class to Test this implementation. </li>
  <li>The web layer contains a model, a controller (Servlet) and JSP views. </li>
</ul>

## What I learned ?
<ul>
  <li> JEE(Servlet,JSP,JSTL) </li>
  <li> Mapping Object Relational with JDBC </li>
  <li> MVC Pattern </li>
</ul>

## How to run ? 

 Make sure  all the tool sare installed (postgreslql, maven,apache tomcat) <br/> 
 
  Step1: clone the project. <br>
                                
  Step2: Execute  db.sql queries <br>
 Change login:"postgres" and password:"mouad" in "IT-product-management-app-/src/main/java/dao/SingletonConnetion.java " with your local configuration. <br>
 
  Step3:
 Execute ***mvn build install*** <br/>
 Deploy the war file on target to tomcat
 
