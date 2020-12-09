package model.game_building;


import java.util.ArrayList;

public class BuildingMode {

	private ParametersValidationListener validationListener;
	// This array will carry the invalid fields and we will use it to check if there are any invalid fields.
	private ArrayList<String> invalidFields;

	public BuildingMode(ParametersValidationListener validationListener){
		this.validationListener = validationListener;
		invalidFields = new ArrayList<>();
	}

	/**
	 * this method is to check if all the parameters of the object ConfigBundle are valid or not at the same time. 
	 * @return true if the parameters are valid, or false otherwise
	 */
	public void validateParameters(ConfigBundle bundle) {
		this.invalidFields.clear();
		if(!isValidNumber(bundle.getNumOfAlphaAtoms()))
			invalidFields.add("Invalid number of Alpha Atoms\n");
		if(!isValidNumber(bundle.getNumOfBetaAtoms()))
			invalidFields.add("Invalid number of Beta Atoms\n");
		if(!isValidNumber(bundle.getNumOfGammaAtoms()))
			invalidFields.add("Invalid number of Gamma Atoms\n");
		if(!isValidNumber(bundle.getNumOfSigmaAtoms()))
			invalidFields.add("Invalid number of Sigma Atoms\n");

		if(!isValidNumber(bundle.getNumAlphaPowerups()))
			invalidFields.add("Invalid number of Alpha Powerups\n");
		if(!isValidNumber(bundle.getNumBetaPowerups()))
			invalidFields.add("Invalid number of Beta Powerups\n");
		if(!isValidNumber(bundle.getNumGammaPowerups()))
			invalidFields.add("Invalid number of Gamma Powerups\n");
		if(!isValidNumber(bundle.getNumSigmaPowerups()))
			invalidFields.add("Invalid number of Sigma Powerups\n");

		if(!isValidNumber(bundle.getNumAlphaBlockers()))
			invalidFields.add("Invalid number of Alpha Blockers\n");
		if(!isValidNumber(bundle.getNumBetaBlockers()))
			invalidFields.add("Invalid number of Beta Blockers\n");
		if(!isValidNumber(bundle.getNumGammaBlockers()))
			invalidFields.add("Invalid number of Gamma Blockers\n");
		if(!isValidNumber(bundle.getNumSigmaBlockers()))
			invalidFields.add("Invalid number of Sigma Blockers\n");

		if(!isValidNumber(bundle.getNumAlphaMolecules()))
			invalidFields.add("Invalid number of Alpha Molecules\n");
		if(!isValidNumber(bundle.getNumBetaMolecules()))
			invalidFields.add("Invalid number of Beta Molecules\n");
		if(!isValidNumber(bundle.getNumGammaMolecules()))
			invalidFields.add("Invalid number of Gamma Molecules\n");
		if(!isValidNumber(bundle.getNumSigmaMolecules()))
			invalidFields.add("Invalid number of Sigma Molecules\n");

		if(!isValidDifficulty(bundle.getDifficulty()))
			invalidFields.add("Invalid Difficulty number\n");
		if(!isValidLength(bundle.getL()))
			invalidFields.add("Invalid Value for L\n");
		if (invalidFields.isEmpty())
			validationListener.onValidParameters();
		else {
			validationListener.onInvalidParameters(invalidFields);
		}

	}
	
	
	/**
	 * this method to check if a given integer is greater than 0 to be valid according to the game's rules 
	 * @param number
	 * @return true if number > 0
	 */
	private boolean isValidNumber(int number) {
		if (number > 0){
			return true;
		}
		return false;
	}
	
	
	/**
	 * this method is to check if the value of the given integer in the range [0,2].
	 * @param difficulty
	 * @return true if difficulty is in range [0,2].
	 */
	private boolean isValidDifficulty(int difficulty) {
		if(difficulty >= 0 && difficulty <= 2){
			return true;
		}
		return false;
	}
	
	
	/**
	 * this method to check if a given integer is greater than 0 to be valid according to the game's rules 
	 * @param l
	 * @return true if l > 0.
	 */
	private boolean isValidLength(double l) {
		if (l > 0)
			return true;
		return false;
	}

	public interface ParametersValidationListener{
		/**
		 * this method is called after game parameters get checked and proved valid.
		 */
		void onValidParameters();

		/**
		 * this method is called after game parameters get checked and proved invalid.
		 * @param message takes a message indicating that some parameters are invalid as well as those parameters.
		 */
		void onInvalidParameters(ArrayList<String> message);
	}



}


