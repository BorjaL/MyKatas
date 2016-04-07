
var character = (function (){

	var attackFunction = function (damage, enemy){

		if (isImpossibleToAttack(this, enemy)){
			return
		}
		if (enemy.health - damage < 0){
			return enemy.health = 0;
		}

		enemy.health = enemy.health - modifiedBooster(damage, enemy, this);
	}

	var isImpossibleToAttack = function (character, enemy){
		return enemy === character || character.calculateRange(enemy) > limitRangeDependingOnAttack(character)
	}

	var healFunction = function (points_of_life, character){
		
		if (canNotHeal(character, this)){
			return
		}

		character.health = character.health + points_of_life;
	}

	var canNotHeal = function (character, myself){
		return character.isDead() || character.health >= 1000 || character !== myself
	}

	var modifiedBooster = function (damage, character, myself){
		if (myself.level - character.level >= 5){
			return damageBooster(damage);
		}

		if (character.level - myself.level >= 5){
			return damageReducer(damage);
		}

		return damage;
	}

	var damageBooster = function(damage){
			return damage + (damage * 0.5);
	}

	var damageReducer = function(damage){
			return damage - (damage * 0.5);
	}

	var setAttackTypeFunction = function(attackType){
		this.attackType = attackType;
	}

	var limitRangeDependingOnAttack = function(character){
		if (character.attackType === "melee") return 2;
		if (character.attackType === "ranger") return 20;
	}

	return {
		health: 1000,
		level: 1,
		attackType: "",
		isAlive: function(){
			return this.health > 0;
		},
		isDead: function(){
			return !this.isAlive();
		},
		attack: attackFunction,
		heal: healFunction,
		setAttackType: setAttackTypeFunction,
		calculateRange: function(enemy){},
	};
});

module.exports = character;