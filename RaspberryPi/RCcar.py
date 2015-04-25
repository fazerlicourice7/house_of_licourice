import pygame, RCcarFunctions, time
pygame.init()
RCcarFunctions.init()
try:
  while True:
   #RCcarFunctions.forward()
    keypressed = pygame.key.get_pressed()
    if keypressed == "pygame.K_w":
      RCcarFunctions.forward()
    elif keypressed  == "pygame.K_a":
      RCcarFunctions.spinleft()
    elif keypressed == "pygame.K_s":
      RCcarFunctions.reverse()
    elif keypressed == "pygame.K_d":
      RCcarFunctions.spinright()
    elif keypressed == "pygame.K_ESCAPE": 
      RCcarFunctions.stop()
    pygame.event.pump()
except KeyboardInterrupt:
  RCcarFunctions.cleanup()
