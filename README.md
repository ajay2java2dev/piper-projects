# Welcome to the piper-projects wiki!
***

## Piper Resume Projects (<a href="https://app.swaggerhub.com/apis/panpiper-services/digi-resume-api/0.0.1">API Specification</a>)
1. piper-resume-service : Spring boot service orchestrating request for resume. 
2. piper-resume-web: React web baed application for resume service. Actions on web app are sent to kafka topic as events.
3. piper-resume-repo: Mongodb supported backend service integrated with piper-resume-service.
4. piper-resume-listener: Kafka based listener service, listening to events from the web and store them onto mongodb.
5. piper-resume-spec: OpenAPI specification with openapi generator support. The specification is located at this <a href="https://app.swaggerhub.com/apis/panpiper-services/digi-resume-api/0.0.1">link</a>.
