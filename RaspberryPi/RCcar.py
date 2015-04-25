import pygame, RCcarFunctions
pygame.init()
RCcarFunctions.init()
try:
  while True:
   #RCcarFunctions.forward()
    keypressed = pygame.key.get_pressed()
    #for event in pygame.event.get():
     # if event.type == pygame.KEYDOWN:
    if keypressed[pygame.K_w]:
      RCcarFunctions.forward()
    elif keypressed[pygame.K_a]:
      RCcarFunctions.spinleft()
    elif keypressed[pygame.K_s]:
      RCcarFunctions.reverse()
    elif keypressed[pygame.K_d]:
      RCcarFunctions.spinright()
    else: 
      RCcarFunctions.stop()
    pygame.event.pump()
except KeyboardInterrupt:
  print ("\ncleaning up")
  RCcarFunctions.cleanup()
