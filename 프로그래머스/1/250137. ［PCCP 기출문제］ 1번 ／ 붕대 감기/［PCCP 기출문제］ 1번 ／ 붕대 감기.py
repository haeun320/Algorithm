def solution(bandage, health, attacks):
    maxHealth = health
    health -= attacks[0][1]
    
    for i in range(1, len(attacks)):
        time = attacks[i][0] - attacks[i-1][0] - 1
        
        health += bandage[1] * time + bandage[2] * (time // bandage[0])
        health = min(health, maxHealth)
        
        health -= attacks[i][1]
        
        if (health <= 0):
            return -1
    
    return health