from twython import Twython, TwythonError
import time

app_key="IUWZ4YKrripATv736Hq4krjiR"
app_secret="87gyigY1Nd2KdWcN3OsJBpaFQ0dluKwnhLUGsqi59libMCGKkT"
oauth_token="3989684499-V3qBUZ3PlZvMDXTi7sBYOJDf0S2SeIM6Fk9E0gX"
oauth_token_secret="DzaZtCPwMqBfrvhpDSjittr5AHwlsIotTwed4oqHoi0LO"

twitter = Twython(app_key, app_secret, oauth_token, oauth_token_secret)

positiveWords = ["rt to win", "rt and fav","follow"]
negativeWords = ["gleam.io","youtube","subscribe","twitch.tv","enter here"]

while True:
  legit = False
  myTweets = twitter.get_user_timeline(screen_name="bboyperfunctory", count = 3200)
  print("got timeline results")
  for Tweet in myTweets:
    tweet=Tweet["text"].lower()
    id = Tweet["id_str"]
    ot = Tweet["user"]["screen_name"]
    if "bot" in ot:
      print("encountered bot")
      try:
        twitter.destry_friendship(ot)
        twitter.destroy_retweet(id)
        twitter.destroy_favorite(id)
      except TwythonError as error:
        print(error)
      for positiveWord in positiveWords:
        for negativeWord in negativeWords:
          if positiveWord in tweet and negativeWord not in tweet:
            legit = True
            break
        break
      if legit == False:
        print("removing tweet and follow if any")
        try:
          twitter.destry_friendship(ot)
          twitter.destroy_retweet(id)
          twitter.destroy_favorite(id)
        except TwythonError as error:
          print(error)
  print("sleeping")
  time.sleep(3600)

