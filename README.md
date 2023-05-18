Test1 This is an example of how to use AngularJS + Feign + Spring Cloud.

Main Point: It has never been easier to do REST in Java.

This application goes to https://api.github.com and lists contributors of a repository.

Feign abstracts the Rest Client and Unmarshalling of JSON objects.

You can run it like a spring boot app:
 mvn spring-boot:run

You can see it working in your browser or curl:
 http://localhost:8080

Ex:
 http://localhost:8080/netflix/hystrix - lists contributors of Hystrix.
 http://localhost:8080/jquery/jquery- lists contributors of jQuery.

Every time you make a request the App goes to the REST github API and gets back with the information populated in a list of Pojos (Contributor.java).

Isn't that really Awesome? Enjoy!

