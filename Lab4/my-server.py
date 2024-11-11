from flask import Flask, request, make_response
import jwt

JWT_SECRET = "super secret"
JWT_ENC_TYPE = "HS256"

app = Flask(__name__)

@app.route("/")
def hello():
   return " you called \n"

# curl -d "text=Hello!&param2=value2" -X POST http://localhost:5000/echo
@app.route("/echo", methods=['POST'])
def echo():
   return "You said: " + request.form['text']



accounts = {
   "bob": "bobpw",
   "joe": "joepw",
   "tim": "timpw",
   "sue": "suepw",
   "kim": "kimpw",
}

authorized = {}




@app.route("/login", methods=['POST'])
def login():
   username = request.form['username']
   password = request.form['password']


   if username in accounts and accounts[username] == password:
      token = jwt.encode({"user": username}, JWT_SECRET, JWT_ENC_TYPE)
      authorized[username] = token
      print(username + " logged in")
      return token
   
   return make_response("login failed", 401)
   

@app.route("/auth", methods=['POST'])
def auth():
   token = request.form['token']
   try:
      payload = jwt.decode(token, JWT_SECRET, JWT_ENC_TYPE)
      user = payload["user"]

      if authorized[user] == token:
         print(user + ' authorized')
         return "auth success! "
   except:
      pass    

   return make_response("auth failed", 401)


if __name__ == "__main__":
   app.run(host='0.0.0.0')