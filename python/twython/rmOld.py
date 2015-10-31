from twython import Twython, TwythonError
import time
from datetime import date

app_key = "IUWZ4YKrripATv736Hq4krjiR"
app_secret = "87gyigY1Nd2KdWcN3OsJBpaFQ0dluKwnhLUGsqi59libMCGKkT"
oauth_token = "3989684499-V3qBUZ3PlZvMDXTi7sBYOJDf0S2SeIM6Fk9E0gX"
oauth_token_secret = "DzaZtCPwMqBfrvhpDSjittr5AHwlsIotTwed4oqHoi0LO"

twitter = Twython(app_key, app_secret, oauth_token, oauth_token_secret)

while True:
  currentDate = date.today() 
  tweets = twitter.get_user_timeline("bboyperfunctory")
  for tweet in tweets["statuses"]:
    date = tweet["created_at"]
    month = date[4:7]
    day = date[8:10]
    if month == "Jan":
      Month = 1
    elif month == "Feb":
      Month = 2
    elif month == "Mar":
      Month = 3
    elif month == "Apr":
      Month = 4
    elif month == "May":   
      Month = 5
    elif month == "June":
      Month = 6
    elif month == "July":
      Month = 7
    elif month == "Aug":
      Month = 8
    elif month == "Sept":
      Month = 9
    elif month == "Oct":
      Month = 10
    elif month == "Nov":
      Month = 11
    elif month == "Dec":
      Month = 12
    totalDays = 0
    for i in range(Month):
      if i == 2:
        totalDays += 29
      elif i < 8 and i%2 != 0:
        totalDays += 31
      elif i > 8 and i%2 == 0:
        totalDays += 31
      else:
        totalDays += 30
    totalDays += day
    if currentDay - totalDays > 28:
      try:
        twitter.destroy_friendship(tweet["user"]["screen_name"])
        twitter.destroy_favorite(tweet["id_str"])
      except TwythonError as error:
        print(error)
