package com.example.a7menuite_project

class Constant {

    companion object{

        fun defaultExerciselist ():ArrayList<exercisemodel>{

            val exercises = ArrayList<exercisemodel>()

            val jumpingjacks = exercisemodel(1,"jumping jacks",R.drawable.ic_jumping_jacks,false,false)
                exercises.add(jumpingjacks)

            val pushup = exercisemodel(2,"push up",R.drawable.ic_push_up,false,false)
            exercises.add(pushup)

            val plank = exercisemodel(3,"plank",R.drawable.ic_plank,false,false)
            exercises.add(plank)

            val crunch = exercisemodel(4,"crunch",R.drawable.ic_abdominal_crunch,false,false)
            exercises.add(crunch)

            val lunge = exercisemodel(5,"lunge",R.drawable.ic_lunge,false,false)
            exercises.add(lunge)

            val pushup_and_rotation = exercisemodel(6,"push up and rotation",R.drawable.ic_push_up_and_rotation,false,false)
            exercises.add(pushup_and_rotation)

            val side_plank = exercisemodel(7,"side plank",R.drawable.ic_side_plank,false,false)
            exercises.add(side_plank)

            val wall_sit = exercisemodel(8,"wall sit",R.drawable.ic_wall_sit,false,false)
            exercises.add(wall_sit)

            val tricepse = exercisemodel(9,"tricepse dip on chair",R.drawable.ic_triceps_dip_on_chair,false,false)
            exercises.add(tricepse)

            val squat = exercisemodel(10,"squat",R.drawable.ic_squat,false,false)
            exercises.add(squat)

            val stepup = exercisemodel(11,"step up onto chair",R.drawable.ic_step_up_onto_chair,false,false)
            exercises.add(stepup)

            val high_knees = exercisemodel(12,"high knees",R.drawable.ic_high_knees_running_in_place,false,false)
            exercises.add(high_knees)

            return exercises
        }
    }
}