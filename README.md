# sb-mongo-1

## Run the api
./mvnw spring-boot:run

## API

/api
	/users
		GET: get all Users
		POST: create a User (valid fields)
		PUT: modify a User
		DELETE: delete a User

## Model
User:
- id
- name
- email
- licenceCode - ZEROT-[A-Z]{3}-[0-9]{3}
- expirationDate - DD/MM/YYYY
