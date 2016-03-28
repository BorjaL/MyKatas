var character;

describe("Character", function(){
	
	beforeEach(function() {
		character = require('../character.js')();
		enemy = require('../character.js')();
	});

	it("starts with 1000 health", function(){

		expect(character.health).toEqual(1000);
	});

	it("starts with level 1", function(){
		expect(character.level).toBe(1);
	});

	it("is alive", function(){
		expect(character.isAlive()).toEqual(true);
	});

	it("is dead", function(){
		character.health = 0;

		expect(character.isDead()).toEqual(true);
	});

	it("can deal damage", function(){
		expect(character.attack).toBeDefined();
	});

	it("deals damage to other character", function(){
		character.attack(100, enemy);

		expect(enemy.health).toEqual(900);
	});

	it("deals more damage than enemy's health, the enemy dies", function(){
		character.attack(1100, enemy);

		expect(enemy.isDead()).toEqual(true);
	});

	it("deals more damage than enemy's health, the enemy has 0 points of life", function(){
		character.attack(1100, enemy);

		expect(enemy.health).toEqual(0);
	});

	it("can heal", function(){
		expect(character.heal).toBeDefined();
	});

	it("can heal and add health", function(){
		enemy.attack(200, character);
		character.heal(100, character);

		expect(character.health).toEqual(900);
	});

	it("can not heal when the other character is dead", function(){
		character.attack(1000, enemy);

		character.heal(100, enemy);

		expect(enemy.isDead()).toEqual(true);
	});

	it("can not heal over 1000 points of life", function(){
		character.heal(100, enemy);

		expect(enemy.health).toEqual(1000);
	});

	it("can not damage to himself", function(){
		character.attack(100, character);

		expect(character.health).toEqual(1000);
	});

	it("only can not heal to an enemy", function(){
		character.attack(100, enemy);

		character.heal(50, enemy);

		expect(enemy.health).toEqual(900);
	});

	it("can damage 50% more if the target is 5 levels below itself", function(){
		character.level = 6;

		character.attack(100, enemy);

		expect(enemy.health).toEqual(850);
	});

	it("can damage 50% more if the target is 5 or more levels below itself", function(){
		character.level = 9;

		character.attack(100, enemy);

		expect(enemy.health).toEqual(850);
	});

	it("can damage 50% less if the target is 5 levels above itself", function(){
		enemy.level = 6;

		character.attack(100, enemy);

		expect(enemy.health).toEqual(950);
	});
});