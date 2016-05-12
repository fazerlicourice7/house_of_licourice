#!/usr/bin/env python2
#encoding: UTF-8

# Copyright (C) 2016 fazer
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.

from twython import Twython

class Tweeter():
    
    app_key = ""
    app_secret = ""
    oauth_token = ""
    oauth_token_secret = ""
    
    twitter = Twython(app_key, app_secret, oauth_token, oauth_token_secret)
    
    def tweet(self, text):
        """tweets the string specified"""
        
        twitter.update_status(status=text)   
