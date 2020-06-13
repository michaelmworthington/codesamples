This is my first nuget package

Notes:
NuGet (2.12.0.0 - https://docs.microsoft.com/en-us/nuget/tools/nuget-exe-cli-reference)
	~/.config/NuGet/NuGet.Config 
		nuget install -verbosity detailed -nocache -source http://localhost:8081/repository/nuget-group/ -version 2.17 moment.js

	*.nuspec
		Create one: Nuget spec
	*.nupkg
		Create one: nuget pack (https://docs.microsoft.com/en-us/nuget/create-packages/creating-a-package)
	Upload
		nuget push -verbosity detailed -source http://localhost:8083/nexus/repository/nuget-hosted -apikey 94b56c39-8e4c-3795-ae28-03b32f5f7ff2  My-Package.1.0.2.nupkg 
		nuget push -verbosity detailed -source http://localhost:8082/nexus/service/local/nuget/nuget-releases/ -apikey f385764b-7662-3b58-81b8-d59b138d5f0d DBDriver.1.0.nupkg 


e407024a525b9d1d90f9
e407024a525b9d1d90f9
e407024a525b9d1d90f9b213296ba102c01bc8d4

58521db33b4c69286f1a
58521db33b4c69286f1a242e05a52d0e4ab8dab3
40a5867344e8d02d9c1eb5ae8691d5e8255725ab