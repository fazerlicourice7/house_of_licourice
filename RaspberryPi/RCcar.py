import pygame, RCcarFunctions
RCcarFunctions.init()
global forward, reverse, left, right
forward, reverse, left, right = False, False, False, False
pygame.init()
pygame.display.init()
size = (pygame.display.Info().current_w, pygame.display.Info().current_h)
pygame.display.set_mode((size), pygame.FULLSCREEN)
pygame.key.set_repeat(500,10)
print ("Succesfully initialized")
try:
  while True:
   #RCcarFunctions.forward()
    keypressed = pygame.key.get_pressed()
    for event in pygame.event.get():
      if event.type == pygame.KEYDOWN:
        if keypressed[pygame.K_w]:
          forward = True
        else:
          forward = False
        if keypressed[pygame.K_a]:
          left = True
        else:
          left = False
        if keypressed[pygame.K_s]:
          reverse = True
        else:
          reverse = False 
        if keypressed[pygame.K_d]:
          right = True
        else:
          right = False
      #elif event.type == pygame.KEYUP:
        #if event.key == pygame.K_w:
          #forward = False
        #elif event.key == pygame.K_a:
          #left = False
        #elif event.key == pygame.K_s:
          #reverse = False
        #elif event.key == pygame.K_d:
          #right = False
      elif event.type == pygame.QUIT:
        RCcarFunctions.cleanup()
        pygame.quit()
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
      RCcarFunctions.brake()
except KeyboardInterrupt:
  print ("\ncleaning up")
  RCcarFunctions.cleanup()
  pygame.quit()
