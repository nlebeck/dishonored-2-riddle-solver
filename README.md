# Jindosh Riddle solver

This is a simple Java program that I wrote to solve the Jindosh Riddle from the
videogame Dishonored 2 using brute force. It is definitely not the cleanest or
most performant code, but it solved the riddle within a minute or two running
on my laptop. Sure, I could have just looked up the solution online, but that
would have gone against the spirit of the game!

## A random note
I thought the text of the riddle was a little unclear as to whether the woman
in blue was sitting immediately to the left of the woman in red or just sitting
*somewhere* to the left of the woman in red. When I was trying to solve the
riddle by hand, that ambiguity made it hard to know whether I was pruning the
solution space the right way -- I initially assumed the former, but then
started assuming the latter. Having solved the riddle with this program, I now
know that the woman in blue was indeed sitting immediately to the left of the
woman in red (since the other assumption results in multiple solutions). I
wonder if I would have been able to solve the riddle by hand if I had known
that my initial, more restrictive assumption was correct...

## The original text of the riddle (from Dishonored 2)
*At the dinner party were Lady Winslow, Doctor Marcolla, Countess Contee, Madam
Natsiou, and Baroness Finch.*

*The women sat in a row. They all wore different colors and Baroness Finch wore
a jaunty white hat. Doctor Marcolla was at the far left, next to the guest
wearing a green jacket. The lady in blue sat left of someone in red. I remember
that blue outfit because the woman spilled her rum all over it. The traveler
from Baleton was dressed entirely in purple. When one of the dinner guests
bragged about her War Medal, the woman next to her said they were finer in
Baleton, where she lived.*

*So Madam Natsiou showed off a prized Snuff Tin, at which the lady from Dabokva
scoffed, saying it was no match for her Ring. Someone else carried a valuable
Diamond and when she saw it, the visitor from Dunwall next to her almost
spilled her neighbor's beer. Lady Winslow raised her absinthe in toast. The
lady from Karnaca, full of whiskey, jumped up onto the table, falling onto the
guest in the center seat, spilling the poor womman's wine. Then Countess COntee
captivated them all with a story about her wild youth in Fraeport.*

*In the morning, there were four heirlooms under the table: the War Medal, Bird
Pendant, the Ring, and the Diamond.*

*But who owned each?*
