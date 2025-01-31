# Live coding assignment (Backend Engineer)

Imagine a store that has trucks deliver the goods in every day. People in the store would like to see how many (and which) things will come in the following days in order to plan their workload, as well as to track the status of each delivery.

Another team will develop a dashboard that will display information about deliveries and their statuses. You are tasked with creating a service for that application.

## Tech stack
Preferably Kotlin, otherwise any JVM language, and SpringBoot.

## Data

The store has multiple systems that communicate mainly with events. Truck delivery events to arrive via events like this:

```json
{
  "id": "TR12370",
  "status": "planned",
  "plannedDeliveryDate": "2022-11-01T10:47:30.641Z",
  "category": "truck",
  "items": [
    {
      "id": "0003a",
      "name": "blue-chair-with-arms",
      "quantity": 3
    },
    {
      "id": "0015f",
      "name": "ceiling-lamp",
      "quantity": 12
    }
  ]
}
```

**Plus**, you need to append incoming event data with carrier information which requires a call to another service. We are interested in the `id` of the carrier company for this delivery.
This service is RESTful and expecting id of the delivery and returns the json `Carrier` entity including the `id` of the carrier which we are interested in.
Implement carrier service integration but just mock the response to be:

```json
{
  "id": 157843, 
  "name": "DHL NL"
}
```

Each event has these fields:
- `id`: string, an identifier of the delivery
- `category`: string, either one of `truck` or `parcel`
- `items`: list, each having an `id` (string), a `name` (string) and a `quantity` (number)
- `plannedDeliveryDate`: string in ISO 8601 format
- `actualDeliveryDate`: optional, string in ISO 8601 format
- `status`: string, one of: `planned`, `in-progress`, `delivered`, `unknown`

Part of your assignment is to decide how to represent this data when storing it, and when serving it.

In order to "consume" the event, implement a class extending the following interface (example is in Kotlin, but the idea should be clear):

```kotlin
interface DeliveryEventConsumer {
  fun consume(event: DeliveryEvent)
}
```

And assume the messages will be consumed via this function.

## API
This service should be able to return the delivery information through an API; the structure and the functionality of that API is up to you.

The frontend team will want at least the following:
- Viewing all deliveries by status and plannedDeliveryTime (between two dates) where either is optional.
- Getting all deliveries by item id.

For simplicity's sake, don't implement authentication, but mention how you would handle security of this system.

## Persistence
You may use the provided h2 database for simplicity or choose any type of database that you feel is suitable for this project.

## Testing
Cover the application with tests. You can use any testing framework you like, doesn't need to cover all written code for the interview purpose, but mention what else you would implement.

- What else would you do to put this code into production?
