URL Shortener Backend Service
Overview
This project is a backend service for a URL Shortener application built using Spring Boot. It supports multiple strategies (engines) for generating unique short URLs including Base64, MD5, and UUID.

Features
Generate Short URLs using different engines:
Base64
MD5 Hash
UUID
Flexible Engine Selection: Users can choose the URL generation engine via an API parameter.
Spring Boot Integration: Uses Spring's Dependency Injection to manage engines and the factory pattern.
RESTful API for creating and resolving URLs.
Thread-Safe Counter: Ensures unique IDs for Base62/Base64 generation.
