from twython import Twython, TwythonError
import time

app_key = "IUWZ4YKrripATv736Hq4krjiR"
app_secret = "87gyigY1Nd2KdWcN3OsJBpaFQ0dluKwnhLUGsqi59libMCGKkT"
oauth_token = "3989684499-V3qBUZ3PlZvMDXTi7sBYOJDf0S2SeIM6Fk9E0gX"
oauth_token_secret = "DzaZtCPwMqBfrvhpDSjittr5AHwlsIotTwed4oqHoi0LO"

twitter = Twython(app_key,app_secret,oauth_token,oauth_token_secret)

tech = ["graphics card","amazon","computer","cpu","phone","android","ios","iphone","smart phone","memory","ram","macbook","imac","mac","windows","laptop","gaming","video game","bestBuy","gaming chair","peripherals","monitors","keyboards","mice","mouse","ipad","camera","video camera","4k","cs","cs:go","counter strike","csgo","csgogiveaway","xbox","x box","ps3","ps4","gamer","pokemon","controllers","headsets"] 
giveaway = ['"rt to win"','"rt and follow to win"','"rt 2 win"','"favorite to win"','"fav to win"','"follow me to enter"','"follow @"','"retweet and like to win"','"rt and like for a chance"','"follow + rt"','"csgogiveaway"']

blacklist = ['-"enter here"','"i entered"','"i just won"','"giving away"','"via /r/"','"will give"','subscribe']
badsite = ["gleam.io","theverge.com",".com","youtube","bit.ly",]

favorite = ["favorite","fav","favourite"]
retweet = ["retweet","rt"]
follow = ["follow"]

searchParam=" OR ".join(giveaway) #+ " -".join(blacklist)
#print(searchParam)
while True:
  try:
    results = twitter.search(q=searchParam, count=12, lang="en")
    #print("got results")
    #print(results)
    for result in results["statuses"]:
      #print("entered result loop")
      Result = result["text"].lower()
      id=result["id_str"]
      links = "       " #result["entities"]["urls"] #["urls"]
      name = result["user"]["screen_name"]
      checkingRT = Result[:3]
      if result["retweeted"] == False and checkingRT != "rt ":
        #print("not a retweet")
        hasbadLink = False
        abot = False
        for site in badsite:
          if site in links:
            hasbadLink = True
        if "bot" in name or "retweet" in name:
          print("is a bot")
          abot = True
        if not hasbadLink and not abot:
          #print("passed all filters")
          for specificTechWord in tech:
            if specificTechWord in Result:
              for rt in retweet:
                if rt in Result:
                  try:
                    print("retweeting")
                    twitter.retweet(id=id)
                    break
                  except TwythonError as retweeted:
                    print(retweeted)
                  for fav in favorite:
                    if fav in Result:
                      try:
                        print("favorite-ing")
                        twitter.create_favorite(id=id)
                        break
                      except TwythonError as favorited:
                        print(favorited)
                  for Follow in follow:
                    if Follow in Result:
                      try:
                        #if result["user"]["following"] == False:
                        print("following")
                        twitter.create_friendship(screen_name=name)
                        break
                      except TwythonError as followed:
                        print(followed)
              break
  except TwythonError as e:
    print("BigError: ", e)
    time.sleep(800)
  print("sleeping")
  time.sleep(60)
  print("done")
  #break

