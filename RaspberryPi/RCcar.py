import pygame, RCcarFunctions

pygame.init()
RCcarFunctions.init()
global forward, reverse, left, right
forward = False
left = False
reverse = False
right = False
try:
  while True:
   #RCcarFunctions.forward()
    #keypressed = pygame.key.get_pressed()
    for event in pygame.event.get():
      if event.type == pygame.KEYDOWN:
        if event.key == pygame.K_w:
          forward = True
        elif event.key == pygame.K_a:
          left = True
        elif event.key == pygame.K_s:
          reverse = True 
        elif event.key == pygame.K_d:
          right = True
      elif event.type == pygame.KEYUP:
        if event.key == pygame.K_w:
          forward = False
        elif event.key == pygame.K_a:
          left = False
        elif event.key == pygame.K_s:
          reverse = False
        elif event.key == pygame.K_d:
          right = False
    if forward & right:
      RCcarFunctions.right()
    elif forward & left:
      RCcarFunctions.left()
    elif forward:
      RCcarFunctions.forward()
    elif left:
      RCcarFunctions.spinleft()
    elif reverse:
      RCcarFunctions.reverse()
    elif right:
      RCcarFunctions.spinright()
    else:
      RCcarFunctions.stop()
except KeyboardInterrupt:
  print ("\ncleaning up")
  RCcarFunctions.cleanup()
