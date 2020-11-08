import java.util.*;
class VarTable {
    ArrayList<VarData> table;

    VarTable() {
        table = new ArrayList<VarData>();
    }

    public void insert(String id, int scope, TypeClass type) throws NewException {
        boolean found = false;
        VarData data = new VarData(id, scope, type);
        while(!found) {
            for(int i = 0; i < table.size(); i++) {
                if(table.get(i).getId().equals(id) && table.get(i).getScope() == scope) {
                    found = true;
                    throw new NewException(id + " is already defined");
                }
            }
            if(!found) {
                table.add(data);
                found = true;
            }
        }
    }

    public void insert(String id, int scope, TypeClass type, TypeClass[] args) throws NewException {
        boolean found = false;
        VarData data = new VarData(id, scope, type, args);
        while(!found) {
            for(int i = 0; i < table.size(); i++) {
                if(table.get(i).getId().equals(id) && table.get(i).getScope() == scope) {
                    found = true;
                    throw new NewException(id + " is already defined with same argument types");
                }
            }
            if(!found) {
                table.add(data);
                found = true;
            }
        }
    }

    public void insert(String id, int scope, TypeClass type, String methodName) throws NewException {
        boolean found = false;
        VarData data = new VarData(id, scope, type, methodName);
        // System.out.println(data.getId() + " " + data.getScope() + " " + data.getType() + " " + data.getMethodName());
        while(!found) {
            for(int i = 0; i < table.size(); i++) {
                if(table.get(i).getId().equals(id) && table.get(i).getScope() == scope && table.get(i).getMethodName() == methodName) {
                    found = true;
                    throw new NewException(id + " is already defined");
                }
            }
            if(!found) {
                table.add(data);
                found = true;
            }
        }
    }

    public void find(String id, int scope) throws NewException {
        boolean found = false;
        for(int i = 0; i < table.size(); i++) {
            if(table.get(i).getId().equals(id) && table.get(i).getScope() <= scope) {
                found = true;
            }
        }
        if(!found) {
            throw new NewException(id + " has not been previously defined");
        }
    }

    public TypeClass getType(String id) throws NewException {
        for(int i = 0; i < table.size(); i++) {
            if(table.get(i).getId().equals(id)) {
                return table.get(i).getType();
            }
        }
        return null;
    }

    public boolean isEqual(TypeClass[] arr1, TypeClass[] arr2) {
        
        if(arr1.length != arr2.length) {
            return false;
        }
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i].getType().toString(0) != arr2[i].getType().toString(0)) {
                return false;
            }
        }
        return true;
    }
}