🌐 URL Shortener Backend Service
📖 Overview
This is a backend service for a URL Shortener application, built with Spring Boot. The service supports multiple strategies (engines) for generating unique short URLs, including:

Base64
MD5 Hash
UUID
With a robust design and flexible architecture, users can select their preferred engine to generate short URLs via an API parameter.

✨ Features
🚀 Generate Short URLs:
Supports multiple engines: Base64, MD5, and UUID.
⚙️ Flexible Engine Selection:
Choose the URL generation engine dynamically via API input.
📡 RESTful API:
Create and resolve short URLs with ease.
🧩 Spring Boot Integration:
Uses Spring's Dependency Injection to manage engines and implement the factory pattern.
🔒 Thread-Safe Counter:
Ensures unique IDs for Base64 generation.

📡 API Documentation
1️⃣ Shorten URL
Endpoint: POST /api/shorten
Description: Generates a short URL for the provided long URL using the specified engine.

Parameter	Type	Description
originalUrl	String	The long URL to shorten (required).
engineType	String	The engine to use: BASE64, MD5, or UUID (required).
Example Request:
bash

curl -X POST "http://localhost:8080/api/v1/urls?originalUrl=http://example.com&engineType=BASE64"

Example Response:
{
  "shortUrl": "http://localhost:8080/abc12345"
}
2️⃣ Resolve Short URL
Endpoint: GET /{shortUrl}
Description: Redirects to the original URL associated with the given short URL.

Parameter	Type	Description
shortUrl	String	The short URL path to resolve (required).
Example Request:
bash

curl -X GET "http://localhost:8080/abc12345"
Behavior:
Redirects to the original URL.
Returns 404 Not Found if the short URL does not exist.

⚙️ Engines
Engine	Description
Base64	Encodes unique IDs using Base64 format to generate an 8-character short URL.
MD5 Hash	Creates a hash of the original URL and trims it to the first 8 characters.
UUID	Generates a random 8-character string using Java's UUID class.
