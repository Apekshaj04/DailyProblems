class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int e = 0 ;
        int te = 0 ;
        for(int t :energy){
            te+=t;
        }
        if(initialEnergy<=te){
            e = te-initialEnergy+1;
        }
        System.out.println(e);
        int exp  = initialExperience;
        int required = 0;
        for(int i = 0;i<experience.length;i++){
            if(experience[i]>=exp){
                required +=experience[i]-exp+1;
                exp += experience[i]-exp+1;
            }
                exp += experience[i];
            
        }
        return required+e;

    }
}