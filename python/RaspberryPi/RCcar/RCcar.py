import RCcarFunctions, pygame
import time
#import RCcarFunctions.py
RCcarFunctions.init()
global forward, reverse, left, right
forward, reverse, left, right = False, False, False, False
pygame.init()
pygame.display.init()
size = (640,480)
pygame.display.set_mode((size))
pygame.key.set_repeat(500,10)
print ("Succesfully initialized")
try:
  while True:
    keypressed = pygame.key.get_pressed()
    for event in pygame.event.get():
      if event.type == pygame.KEYDOWN:
        if keypressed[pygame.K_w]:
          forward = True
        elif keypressed[pygame.K_s]:
          reverse = True
        elif keypressed[pygame.K_a]:
          left = True
        elif keypressed[pygame.K_d]:
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
        pygame.quit()
    if forward & right:
      RCcarFunctions.right()
    elif forward & left:
      RCcarFunctions.left()
    elif left:
      RCcarFunctions.left()
    elif right:
      RCcarFunctions.right()
    elif forward:
      RCcarFunctions.forward()
      RCcarFunctions.straight()
    elif reverse:
      RCcarFunctions.reverse()
      RCcarFunctions.straight()
    else:
      RCcarFunctions.straight()
      RCcarFunctions.brake()
    time.sleep(0.5)
except KeyboardInterrupt:
  print ("\ncleaning up")
  RCcarFunctions.cleanup()
  pygame.quit()
