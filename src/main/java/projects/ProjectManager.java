package projects;

import java.util.ArrayList;

import static projects.Project.Finished;

/**
 * Created by nichita on 04/01/17.
 */
public class ProjectManager {

    private ArrayList<Project> projects = new ArrayList<>();

    public void create(String project){
        Project p = null;
        switch (project){
            case "Hob": p=new AutoHob();
            break;
            case "Tur": p=new Turret();
            break;
        }
        if(p!=null) projects.add(p);
    }

    public int numProjects(){
        return projects.size();
    }

    private void clean(){
        projects.removeIf(Finished);
    }

    public void lucru(int workUnits){
        for(Project p:projects){
            int cost = p.getBuildLeft();
            workUnits-=cost;

            int completed = cost;
            if(workUnits<0) completed += workUnits;

            p.advance(completed);
        }

        clean();

    }

}
