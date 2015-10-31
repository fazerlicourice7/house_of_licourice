from twython import Twython, TwythonError 
import time

app_key = "IUWZ4YKrripATv736Hq4krjiR" 
app_secret = "87gyigY1Nd2KdWcN3OsJBpaFQ0dluKwnhLUGsqi59libMCGKkT" 
oauth_token = "3989684499-V3qBUZ3PlZvMDXTi7sBYOJDf0S2SeIM6Fk9E0gX" 
oauth_token_secret = "DzaZtCPwMqBfrvhpDSjittr5AHwlsIotTwed4oqHoi0LO"

twitter = Twython(app_key,app_secret,oauth_token,oauth_token_secret)

tech = ["graphics card","amazon","computer","cpu","phone","android","ios","iphone","smart phone","memory","ram","macbook","imac","mac","windows","laptop","gaming","video game","bestBuy","gaming chair","peripherals","monitors","keyboards","mice","mouse","ipad","camera","video camera","4k","cs","cs:go","counter strike","csgo","xbox","x box","ps3","ps4","gamer","pokemon","digital code","controllers","headsets"] 
giveaway = ["rt to win","rt and follow to win","rt 2 win","rt/fav"]

favorite = ["favorite","fav","favourite"] 
retweet = ["retweet","rt"] 
follow = ["follow"]

giveaway += favorite + retweet + follow
Giveaway=" OR ".join(giveaway)

while True:
  try:
    results = twitter.search(q=Giveaway, count=12, result_type="recent")
    for result in results["statuses"]:
      Result = result["text"].lower()
      id=result["id_str"]
      if result["retweeted"] == True:
        eon = Result.index(":")
        name = Result[4:eon]
      else:
        name = result["user"]["screen_name"]
      for specificTechWord in tech:
        if specificTechWord in Result:
          for fav in favorite:
            if fav in Result:
              try:
                print("favorite-ing")
                twitter.create_favorite(id=id)
                break
              except TwythonError as favorited:
                print(favorited)                     
          for rt in retweet:
            if rt in Result:
              try:
                print("retweeting")
                twitter.retweet(id=id)
                break
              except TwythonError as retweeted:
                print(retweeted)
          for Follow in follow:
            if Follow in Result:
              try:
                if result["user"]["following"] == False:
                  print("following")
                  twitter.create_friendship(screen_name=name)
                break
              except TwythonError as followed:
                print(followed)
          break  
  except TwythonError as e:
    print(e)
    time.sleep(800)
  print("sleeping")
  time.sleep(60)
  print("done")
  break

