#To test (All operations support both XML and JSON):
 - Send a GET req to http://www.salsaeternity.com:8081/api/users to retrieve a list of all users in the DB (Supports boths XML and JSON)

 - Send a POST req to http://www.salsaeternity.com:8081/api/users with a JSON/XML data to add a new user
 
 - Send a GET req to http://www.salsaeternity.com:8081/api/users/(Here Goes the user's emailAddres) to retrieve one user
 
 - Sent a PUT req to http://www.salsaeternity.com:8081/api/users/(Here Goes the user's emailAddress) to modify an existing user (body : XML/JSON of the user)
 
 - Send a DELETE req  http://www.salsaeternity.com:8081/api/users/(Here Goes the user's emailAddress) to delete one user


# RESTJAXrsUsersDB
This is a simple lightweight RESTful web service that uses the following frameworks/technologies:

JAX-rs, 
Jersey (as a Servlet/Framework for JAX-rs),
Jackson (for JSON support),
JAXB (for XML/JSON binding),
Morphia (for the MongoDB connection)

It implements CRUD operations to interact with a nosql db (MongoDB in this case)


Tested using Advanced REST client (available in GoogleChrome store for free)


