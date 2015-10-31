from twython import Twython

app_key= "IUWZ4YKrripATv736Hq4krjiR"
app_secret= "87gyigY1Nd2KdWcN3OsJBpaFQ0dluKwnhLUGsqi59libMCGKkT"
oauth_token= "3989684499-V3qBUZ3PlZvMDXTi7sBYOJDf0S2SeIM6Fk9E0gX"
oauth_token_secret= "DzaZtCPwMqBfrvhpDSjittr5AHwlsIotTwed4oqHoi0LO"

twitter=Twython(app_key,app_secret,oauth_token,oauth_token_secret)

twitter.update_status(status="Hello World")
