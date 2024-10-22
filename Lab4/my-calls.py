import httpx

url = "https://turbo-bassoon-7vrqp59xvr4rcr7q5-5000.app.github.dev/"

response = httpx.get(url)
print(response.status_code)
print(response)
print()



response = httpx.get(url)
print(response.status_code)
print(response.text)
print()

mydata = {
    "text": "Hello Phil!",
    "param2": "Making a POST request",
    "body": "my own value"
}

# A POST request to the API
response = httpx.post(url + "echo", data=mydata)

# Print the response
print(response.status_code)
print(response.text) 
print()


def test_auth(loginData):
    # Test /login api
    u, p = loginData["username"], loginData["password"]
    # A POST request to the API
    response = httpx.post(url + "login", data=loginData)
    token = response.text.split('\n')[-1]
    # Print the response
    print(response.status_code)
    print(response.text)
    print()

    # Test /auth api

    authData = {
        "user": u,
        "token": token
    }
    # A POST request to the API
    response = httpx.post(url + "auth", data=authData)

    # Print the response
    print(response.status_code)
    print(response.text)
    print()



loginDataArr = [
    {"username": "bob", "password": "bobpw"},
    {"username": "joe", "password": "joepw"},
    {"username": "tim", "password": "timpw"},
    {"username": "sue", "password": "suepw"},
    {"username": "kim", "password": "kimpw"},
    {"username": "kim", "password": "kimpwXX"}  # test valid user with incorrect pw
]

for loginData in loginDataArr:
    test_auth(loginData)