import pygame, RCcarFunctions, time

pygame.init()
keypressed = pygame.key.get_pressed()
try:
  while True:
    if keypressed == "pygame.K_w":
      carfunctions.forward()
    elif keypressed  == "pygame.K_a":
      carfunctions.spinleft()
    elif keypressed == "pygame.K_s":
      carfunctions.reverse()
    elif keypressed == "pygame.K_d":
      carfunctions.spinright()
    elif keypressed == "pygame.K_ESCAPE": 
      carfunctions.stop()
    pygame.event.pump()
except KeyboardInterrupt:
  carfunctions.cleanup()
