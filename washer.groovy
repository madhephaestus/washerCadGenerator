import eu.mihosoft.vrl.v3d.parametrics.*;
CSG generate(){
	String type= "washer"
	if(args==null)
		args=["M5"]
	// The variable that stores the current size of this vitamin
	StringParameter size = new StringParameter(	type+" Default",args.get(0),Vitamins.listVitaminSizes(type))
	HashMap<String,Object> measurments = Vitamins.getConfiguration( type,size.getStrValue())

	def odValue = measurments.od
	def idValue = measurments.id
	println "Measurment odValue =  "+odValue
	println "Measurment idValue =  "+idValue
	// Stub of a CAD object
	CSG part = new Cube().toCSG()
	return part
		.setParameter(size)
		.setRegenerate({generate()})
}
return generate() 