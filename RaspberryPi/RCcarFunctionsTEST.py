import RCcarFunctions as RCcar
import time

RCcar.init()
while True:
  RCcar.forward()
  time.sleep(2)
  
  RCcar.brake()
  time.sleep(2)
 
  RCcar.reverse()
  time.sleep(2)

  RCcar.brake()
  time.sleep(2)
  
  RCcar.left()
  time.sleep(2)
  
  RCcar.brake()
  time.sleep(2)

  RCcar.right()
  time.sleep(2)
  
  RCcar.brake()
  time.sleep(2)



