import requests

r = requests.get('http://127.0.0.1:8081/hello/gift/1/')
#get json
data = r.json()

print(data)
