package HospitalManagementSystem;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Controller {
    private Map<String, Patient> patients=new ConcurrentHashMap<>();
    private PriorityQueue<Pair>pq= new PriorityQueue<>(Comparator.comparing(Pair::getVal).reversed());
    public void addPatient(Patient patient)
    {
        patients.put(patient.getId(),patient);
        int val=patient.getPriorityLevel().getVal();
        pq.add(new Pair(val,patient.getId()));
    }
    public void assignLevel(String patientId, PriorityLevel priorityLevel){
        patients.get(patientId).setPriorityLevel(priorityLevel);
    }

    public void takePatient()
    {
        Pair top= pq.poll();
        String patientId=top.getId();
        System.out.println("assignng patient with id"+patientId);
    }
}
