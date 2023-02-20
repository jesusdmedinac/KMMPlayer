import SwiftUI
import MultiPlatformLibrary
import Combine

struct ContentView: View {
    let playerViewModel: PlayerViewModel
    @State var playerState: PlayerState?
    
    init() {
        self.playerViewModel = PlayerViewModelImpl(itemRepository: ItemRepositoryImpl(realm: AppDatabase.init().realm()))
        self.playerState = nil
    }

	var body: some View {
        VStack{
            Text(self.playerState?.hola ?? false ? "true" : "false")
            Button("Again", action: {
                playerViewModel.onLoad()
            })
            LazyVStack {
                ForEach(playerState?.items ?? [], id: \.self) { item in
                    let itemSummary = (item as? PlayerState.Item ?? PlayerState.Item(id: 0, isComplete: false, summary: "", ownerId: 0)).summary
                    Text("\(itemSummary)")
                }
            }
        }
            .onAppear {
                collectState()
            }
	}
    
    func collectState() {
        let commonFlow = CommonFlow<PlayerState>.init(source: playerViewModel.container.stateFlow, scope: playerViewModel.scope)
        commonFlow.collect { playerState in
            self.playerState = playerState
        } onCompletion: {
            
        } onException: { KotlinThrowable in
            
        }
        
        playerViewModel.onLoad()
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
