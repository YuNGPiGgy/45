/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//tzulingw Tzu-Ling Wang	77721457
//----------------------------------
//
//
************************/
/*
o	A class representing all the information for a single craps game. This includes:
	o	Number of times a roll happened
	o	A CrapsMetricsMonitor object
o	Public methods that this class must implement are:
	o	CrapsGame(CrapsMetricsMonitor    monitor)
		o	Constructor that initializes the class fields. 
			A CrapsMetricsMonitor is passed into the constructor 
			since there are specific stats within a single game 
			that must be updated (and the same object should be used 
			for all metrics in the simulation).
	o	boolean  playGame()
		o	Contains the algorithm for an actual game.

 */