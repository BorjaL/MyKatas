
var character = (function (){

	var attackFunction = function (damage, character){

		if (character === this){
			return
		}
		if (character.health - damage < 0){
			return character.health = 0;
		}

		character.health = character.health - modifiedBooster(damage, character, this);
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

	return {
		health: 1000,
		level: 1,
		isAlive: function(){
			return this.health > 0;
		},
		isDead: function(){
			return !this.isAlive();
		},
		attack: attackFunction,
		heal: healFunction,
	};
});

module.exports = character;