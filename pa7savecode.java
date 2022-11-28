	@Override
	public V get(K key) throws IllegalArgumentException {
		
		if(key == null) {
			throw new IllegalArgumentException();
		}

		Node<K, V> current = root;
		
		boolean toContinue;
		boolean keyFound = false;
		
		if(!isEmpty()) {
			toContinue = true;
		}
		else {
			toContinue = false;
			return null;
		}
	
		while(toContinue) {
			int comp1 = key.compareTo(current.key);
			
			if(comp1 == 0) {
				toContinue = false;
				keyFound = true;
				//return current.value;
				
			}
			
			if(comp1 > 0) {
				while(current.rightChild != null && !current.key.equals(key)) {
					current = current.rightChild;
					keyFound = false;
				}
				toContinue = false;
			}
			
			if(comp1 < 0) {
				while(current.leftChild != null && !current.key.equals(key)) {
					current = current.rightChild;
					keyFound = false;
				}
				toContinue = false;
				
			}
		}
		if(size == 0) {
			return null;
		}
		
		if(keyFound) {
			return current.value;
		}
		else {
			return null;
		}

    
    
    
    	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {

		if(key == null) {
			throw new IllegalArgumentException();
		}

		Node<K, V> current = root;
		
		boolean toContinue;
		boolean keyFound = false;
		
		if(!isEmpty()) {
			toContinue = true;
		}
		else {
			toContinue = false;
			return false;
		}
	
		while(toContinue) {
			int comp1 = key.compareTo(current.key);
			
			if(comp1 == 0) {
				toContinue = false;
				keyFound = true;
				
			}
			
			if(comp1 > 0) {
				while(current.rightChild != null && !current.key.equals(key)) {
					current = current.rightChild;
					keyFound = false;
				}
				toContinue = false;
			}
			
			if(comp1 < 0) {
				while(current.leftChild != null && !current.key.equals(key)) {
					current = current.rightChild;
					keyFound = false;
				}
				toContinue = false;
				
			}
		}
		if(size == 0) {
			return false;
		}
		
		if(keyFound) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
