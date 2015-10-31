from twython import Twython, TwythonError
import time

app_key = "IUWZ4YKrripATv736Hq4krjiR"
app_secret = "87gyigY1Nd2KdWcN3OsJBpaFQ0dluKwnhLUGsqi59libMCGKkT"
oauth_token = "3989684499-V3qBUZ3PlZvMDXTi7sBYOJDf0S2SeIM6Fk9E0gX"
oauth_token_secret = "DzaZtCPwMqBfrvhpDSjittr5AHwlsIotTwed4oqHoi0LO"

twitter = Twython(app_key, app_secret, oauth_token, oauth_token_secret)

favorite=["favorite","fav","FAV","Favorite"]
follow=["follow","Follow","FOLLOW"]

while True:
  try:
    tweets = twitter.search(q="csgogiveaway -stream -sub -twitch -Twitch -youtube", count = 12, result_type="recent")
    for tweet in tweets["statuses"]:
      if tweet["retweeted"] == False:
        text = tweet["text"]
        id = tweet["id_str"]
        try:
          twitter.retweet(id=id)
        except TwythonError as retweetError:
          print(retweetError)
        for FOLLOW in follow:
          if FOLLOW in text:
            try:
              eon = text.index(":")
              name = text[4:eon]
              twitter.create_friendship(screen_name = name)
            except TwythonError as followError:
              print(followError)
        for FAV in favorite:
          if "fav" in text:
            try:
              twitter.create_favorite(id=id)
            except TwythonError as favError:
              print(favError)
    time.sleep(60)
  except TwythonError as tooManyRequests:
    print(tooManyRequests)
    time.sleep(800)
