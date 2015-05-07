import pygame, RCcarFunctions
#pygame.display.init()
#pygame.display.set_mode((1280,720)))
RCcarFunctions.init()
global forward, reverse, left, right
forward = False
left = False
reverse = False
right = False
pygame.init()
pygame.key.set_repeat(500,10)
print ("Succesfully initialized")
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
      elif event.type == pygame.QUIT:
        RCcarFunctions.cleanup()
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
  pygame.quit()
