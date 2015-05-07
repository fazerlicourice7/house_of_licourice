import RCcarFunctions, termios, os, sys

def getkey():
        fd = sys.stdin.fileno()
        old = termios.tcgetattr(fd)
        new = termios.tcgetattr(fd)
        new[3] = new[3] & ~TERMIOS.ICANON & ~TERMIOS.ECHO
        new[6][TERMIOS.VMIN] = 1
        new[6][TERMIOS.VTIME] = 0
        termios.tcsetattr(fd, TERMIOS.TCSANOW, new)
        c = None
        try:
                c = os.read(fd, 1)
        finally:
                termios.tcsetattr(fd, TERMIOS.TCSAFLUSH, old)
        return c
try:
  while True:
    keyp = getkey()
    if keyp == 'w':
      RCcarFunctions.forward()
    elif keyp == 's':
      RCcarFunctions.reverse()
    elif keyp == 'a':
      RCcarFunctions.spinleft()
    elif keyp == 'd':
      RCcarFunctions.spinright()
    else:
      RCcarFunctions.brake();
except KeyboardInterrupt:
  RCcarFunctions.cleanup()
