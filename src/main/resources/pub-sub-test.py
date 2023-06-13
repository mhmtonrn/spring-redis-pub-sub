import random

from locust import HttpUser, task


class User(HttpUser):

    @task
    def pub(self):
        response = self.client.post("/api/publish?message={}".format(random.randint(1, 10000)))
        # time.sleep(1)
        print(response.json())
