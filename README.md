# maze


A maze is constructed with empty spaces (0) and walls (1). There is a ball in the maze that can go through the empty spaces by going up, down, left or // right. But it will not stop until hitting the wall.
When the ball stops, it could choose the next direction.
 
Given the maze, the ball's start position and the destination, return true if the ball can stop at the destination, otherwise return false.
Input:
maze = [
 [0,0,1,0,0],
 [0,0,0,0,0],
 [0,0,0,1,0],
 [1,1,0,1,1],
 [0,0,0,0,0]
 ]
 
 start = [0,0]
 destination = [4,4]
 res: true
