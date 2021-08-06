# rest-service
**REST API IN JAVA SPRING BOOT**
**PROJECT NAME: rest-service**

_PROJECT DESCRIPTION:_
This project is an Application Programming Interface designed for web services, hence it is based on the REST architecture. 
It facilitates the input to output process for Optical Character Recognition. Firstly, it takes relevant image information 
from the client, then it allows for Optical Character Recognition to be performed on the images, following this it stores
the extracted information in a CSV file.

_Note on API:_
APIs connect a client(a website) and a server. In our case the client is giving input of image details, and the API is calling
the OCR service to perform OCR after which the extracted data is stored. The input to API by client is in JSON format and
at any point when a response is to be given to the client regarding status of OCR, it is in JSON format. The API takes input 
and creates a new file, hence it utilizes the HTTP POST method.

_Note on SPRING:_
The project uses spring boot. Spring boot allows for fast creation of production-grade spring applications and enables coding
in simple object oriented java by reducing complexity and development time. For testing the application a localhost url
is also generated. All the relevant maven dependencies have been added in the pom.xml file 

_PACKAGES AND CLASSES:_
The main RestServiceApplication class is from where we run the application.
The remaining classes that form the body of the program are in the package iexceed.tools. This package has two subpackages:
1) dto(data transfer object): This has all the classes whose objects are going to be used in the program. They have been 
   created with the necessary fields and methods.
2) rest: This has two classes - Controller, which is responsible for taking in input and sending it ahead to be processed, and
   to give the response to the client; RequestHandler, which takes the input request from the Controller and carries out the
   OCR process, it also relays a response to the Controller class regarding status of execution.
   
_FLOW OF PROGRAM:_
(Objects of a class will be referred to by their class name but with lowercase first letter)
1.Execution starts from the Controller class because the Test method is mapped to the url. The method is responsible for
  taking the json input and obtaining it as the java object - request. The request is sent to RequestHandler class. Following
  steps take place in RequestHandler class.
2.Input and output directories are obtained from request. Input directory is the directory which has the image files and
  output directory is where the csv file is created and updated. A csv file is created at output directory.
3.The input directory is checked through a loop. Directories are skipped while files are processed. The steps 4 to 8 are
  carried out for each image file
4.Image is converted into base64.
5.The ocrrequest object is populated with relevant information including the base64 value.
6.RestTemplate calls the OCR service. It accepts ocrrequest and in turn returns a ocrresponse object. The extracted information
  are stored in the object field of ocrresponse known as ExtractedEntities.
7.ExtractedEntities is converted into a JsonObject to extract keys and values of the keys.
8.The keys(id,name,age etc), and their values for that image are then updated in the csv file.
9.RequestHandler returns a response of error or successful status to Controller based on the outcome.

_CONCLUDING REMARKS:_
ExtractedEntities to JsonObject is incomplete. Everywhere values are hardcoded because the azure url for OCR service is not yet
available, therefore the RestTemplate line is commented, and the ocrresponse is hardcoded. The following is the JSON input
body whenever the code is to be tested:
{
"document_type": "EMIRATES_ID",
"user_id": "admin",
"document_id": "Emirates_Front",
"input_dir":"xyz",
"output_dir":"xyz"
}

Thank you:)
#Edit readme if required after updating code




